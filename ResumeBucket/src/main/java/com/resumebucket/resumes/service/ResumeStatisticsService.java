package com.resumebucket.resumes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.resumebucket.resumes.model.SearchWhereTheyLiveResponse;
import com.resumebucket.resumes.model.SearchWhereTheyStudyResponse;
import com.resumebucket.resumes.repository.ResumeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResumeStatisticsService {

	@Autowired
	private ResumeRepository resumeRepository;

	
	public Page<SearchWhereTheyLiveResponse> searchWhereTheyLive(Pageable pageable) {
		
		Page<SearchWhereTheyLiveResponse> searchWhereTheyLiveResponsePage =  resumeRepository.searchWhereTheyLive(pageable);
		
		log.info("Resumes searched. Page<SearchWhereTheyLiveResponse>: " + searchWhereTheyLiveResponsePage.toString());
		
		return searchWhereTheyLiveResponsePage;
		
	}
	
	public Page<SearchWhereTheyStudyResponse> searchWhereTheyStudy(Pageable pageable) {
		
		Page<SearchWhereTheyStudyResponse> searchWhereTheyStudyResponsePage = resumeRepository.searchWhereTheyStudy(pageable);
		
		log.info("Resumes searched. Page<SearchWhereTheyStudyResponse>: " + searchWhereTheyStudyResponsePage.toString());
		
		return searchWhereTheyStudyResponsePage;
		
	}

}
