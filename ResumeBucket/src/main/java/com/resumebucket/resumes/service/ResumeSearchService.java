package com.resumebucket.resumes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.mapper.ResumeSearchMapper;
import com.resumebucket.resumes.model.SearchResumeRequest;
import com.resumebucket.resumes.model.SearchResumeResponse;
import com.resumebucket.resumes.repository.ResumeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResumeSearchService {

	@Autowired
	private ResumeSearchMapper resumeSearchMapper;

	@Autowired
	private ResumeRepository resumeRepository;

	
	public Page<SearchResumeResponse> searchResume(SearchResumeRequest searchResumeRequest, Pageable pageable) {
		SearchPage<Resume> searchResumePage = resumeRepository.searchResume(searchResumeRequest, pageable);
		
		Page<SearchResumeResponse>  searchResumeResponsePage = resumeSearchMapper.toSearchResumeResponse(searchResumePage);
		
		log.info("Resumes searched. Page<SearchResumeResponse>: " + searchResumeResponsePage.toString());
		
		return searchResumeResponsePage;

	}

}
