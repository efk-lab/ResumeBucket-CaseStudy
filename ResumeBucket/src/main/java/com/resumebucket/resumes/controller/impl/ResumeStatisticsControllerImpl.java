package com.resumebucket.resumes.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.resumebucket.resumes.controller.ResumeStatisticsController;
import com.resumebucket.resumes.model.SearchWhereTheyLiveResponse;
import com.resumebucket.resumes.model.SearchWhereTheyStudyResponse;
import com.resumebucket.resumes.service.ResumeStatisticsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResumeStatisticsControllerImpl implements ResumeStatisticsController {

	@Autowired
	private ResumeStatisticsService resumeStatisticsService;


	@Override
	public ResponseEntity<Page<SearchWhereTheyLiveResponse>> searchWhereTheyLive(int pageNumber, int pageSize) {
		log.info("SearchWhereTheyLiveRequest received.");

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		
		Page<SearchWhereTheyLiveResponse> pageSearchWhereTheyLiveResponse = resumeStatisticsService.searchWhereTheyLive(pageable);

		if (pageSearchWhereTheyLiveResponse != null) {
			return new ResponseEntity<>(pageSearchWhereTheyLiveResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pageSearchWhereTheyLiveResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Page<SearchWhereTheyStudyResponse>> searchWhereTheyStudy(int pageNumber, int pageSize) {
		log.info("SearchWhereTheyStudyRequest received.");

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		
		Page<SearchWhereTheyStudyResponse> pageSearchWhereTheyStudyResponse = resumeStatisticsService.searchWhereTheyStudy(pageable);

		if (pageSearchWhereTheyStudyResponse != null) {
			return new ResponseEntity<>(pageSearchWhereTheyStudyResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pageSearchWhereTheyStudyResponse, HttpStatus.NO_CONTENT);
		}
	}

}
