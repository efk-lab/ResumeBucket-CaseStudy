package com.resumebucket.resumes.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.resumebucket.resumes.document.Resume;

@Repository
public interface ResumeRepository extends ElasticsearchRepository<Resume, String> , ResumeRepositoryCustom{

}
