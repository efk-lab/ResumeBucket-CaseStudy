package com.resumebucket.resumes.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.resumebucket.resumes.document.event.ResumeStateChangedEvent;

@Repository
public interface ResumeStateChangedEventRepository extends ElasticsearchRepository<ResumeStateChangedEvent, String>{

}
