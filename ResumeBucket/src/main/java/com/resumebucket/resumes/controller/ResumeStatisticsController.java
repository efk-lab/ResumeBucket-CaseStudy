package com.resumebucket.resumes.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.resumebucket.resumes.model.SearchWhereTheyLiveResponse;
import com.resumebucket.resumes.model.SearchWhereTheyStudyResponse;

@RequestMapping("/resumebucket/statistics")
public interface ResumeStatisticsController {

	@RequestMapping(
			value = "/where-they-live", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    ResponseEntity<Page<SearchWhereTheyLiveResponse>> searchWhereTheyLive(@RequestParam int pageNumber,  @RequestParam int pageSize);
	
	
	@RequestMapping(
			value = "/where-they-study", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    ResponseEntity<Page<SearchWhereTheyStudyResponse>> searchWhereTheyStudy(@RequestParam int pageNumber,  @RequestParam int pageSize);
}
