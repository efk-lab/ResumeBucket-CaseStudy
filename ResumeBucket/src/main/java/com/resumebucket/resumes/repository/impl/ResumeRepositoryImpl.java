package com.resumebucket.resumes.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.clients.elasticsearch7.ElasticsearchAggregations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.model.SearchResumeRequest;
import com.resumebucket.resumes.model.SearchWhereTheyLiveResponse;
import com.resumebucket.resumes.model.SearchWhereTheyStudyResponse;
import com.resumebucket.resumes.repository.ResumeRepositoryCustom;

public class ResumeRepositoryImpl implements ResumeRepositoryCustom {
	
	@Autowired
	private ElasticsearchOperations elasticsearchOperations;
	
	
	@Override
	public SearchPage<Resume> searchResume(SearchResumeRequest searchResumeRequest, Pageable pageable) {

		QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(searchResumeRequest.getSearchText())
													.fuzziness(Fuzziness.ONE) 
													.prefixLength(2);


		NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(queryBuilder)
																.withPageable(pageable)
																.build();

		SearchHits<Resume> hits = elasticsearchOperations.search(query, Resume.class);

		return SearchHitSupport.searchPageFor(hits, query.getPageable());

	}
	
	@Override
	public Page<SearchWhereTheyLiveResponse> searchWhereTheyLive(Pageable pageable) {
		
		TermsAggregationBuilder aggregationBuilders = AggregationBuilders.terms("cities").field("contact.city.keyword");

		NativeSearchQuery query = new NativeSearchQueryBuilder()
			        					.withQuery(QueryBuilders.matchAllQuery())
			        					.withAggregations(aggregationBuilders)
			        					.build();
		
		SearchHits<Resume> searchHits = elasticsearchOperations.search(query, Resume.class);
		
		ElasticsearchAggregations aggregations = (ElasticsearchAggregations) searchHits.getAggregations();
		
		Terms cities = aggregations.aggregations().get("cities");
		var buckets = cities.getBuckets();
		
		List<SearchWhereTheyLiveResponse> whereTheyLiveList = new ArrayList<SearchWhereTheyLiveResponse>();
		
		buckets.forEach(bucket -> whereTheyLiveList.add(SearchWhereTheyLiveResponse.builder()
															.city(bucket.getKeyAsString())
															.count(Math.toIntExact(bucket.getDocCount()))
															.build()));

		return new PageImpl<>(whereTheyLiveList, pageable, searchHits.getTotalHits());
		
	}
	
	@Override
	public Page<SearchWhereTheyStudyResponse> searchWhereTheyStudy(Pageable pageable) {
		
		TermsAggregationBuilder aggregationBuilders = AggregationBuilders.terms("schools").field("educations.schoolName.keyword");

		NativeSearchQuery query = new NativeSearchQueryBuilder()
			        					.withQuery(QueryBuilders.matchAllQuery())
			        					.withAggregations(aggregationBuilders)
			        					.build();
		
		SearchHits<Resume> searchHits = elasticsearchOperations.search(query, Resume.class);
	
		ElasticsearchAggregations aggregations = (ElasticsearchAggregations) searchHits.getAggregations();
		
		Terms schools = aggregations.aggregations().get("schools");
		var buckets = schools.getBuckets();
		
		List<SearchWhereTheyStudyResponse> whereTheyStudyList = new ArrayList<SearchWhereTheyStudyResponse>();
		buckets.forEach(bucket -> whereTheyStudyList.add(SearchWhereTheyStudyResponse.builder()
															.schoolName(bucket.getKeyAsString())
															.count(Math.toIntExact(bucket.getDocCount()))
															.build()));
		

		return new PageImpl<>(whereTheyStudyList, pageable, searchHits.getTotalHits());
		
	}

}
