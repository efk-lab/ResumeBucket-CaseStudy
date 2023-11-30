package com.resumebucket.resumes.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Component;

import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.model.SearchResumeResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResumeSearchMapper {
	
	public Page<SearchResumeResponse> toSearchResumeResponse(SearchPage<Resume> searchPage) {
		
		log.info("Mapping Resume page to SearchResumeResponse page. searchPage:" + searchPage.toString());
		
		List<SearchResumeResponse> searchResumeResponseList = new ArrayList<SearchResumeResponse>();
		
		SearchHits<Resume> searchHits = searchPage.getSearchHits();
		

		searchHits.stream().forEach(searchHit -> searchResumeResponseList.add(SearchResumeResponse.builder()
																									.resumeId(searchHit.getContent().getId())
																									.firstName(searchHit.getContent().getContact().getFirstName())
																									.lastName(searchHit.getContent().getContact().getLastName())
																									.build()));
		
		return new PageImpl<>(searchResumeResponseList, searchPage.getPageable(), searchHits.getTotalHits());
		
	}
	
}
