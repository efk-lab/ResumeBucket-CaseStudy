package com.resumebucket.resumes.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.resumebucket.resumes.controller.ResumeSearchController;
import com.resumebucket.resumes.model.SearchResumeRequest;
import com.resumebucket.resumes.model.SearchResumeResponse;
import com.resumebucket.resumes.service.ResumeSearchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResumeSearchControllerImpl implements ResumeSearchController {

	@Autowired
	private ResumeSearchService resumeSearchService;
	

	@Override
	public ResponseEntity<Page<SearchResumeResponse>> searchResume(@Valid SearchResumeRequest searchResumeRequest, int pageNumber, int pageSize) {
		log.info("SearchResumeRequest received: " + searchResumeRequest.toString());

		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		
		Page<SearchResumeResponse> pageSearchResumeResponse = resumeSearchService.searchResume(searchResumeRequest, pageable);

		if (pageSearchResumeResponse != null) {
			return new ResponseEntity<>(pageSearchResumeResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pageSearchResumeResponse, HttpStatus.NO_CONTENT);
		}
	}

}
