package com.resumebucket.resumes.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.resumebucket.resumes.model.SearchResumeRequest;
import com.resumebucket.resumes.model.SearchResumeResponse;

@RequestMapping("/resumebucket/resume")
public interface ResumeSearchController {

	@RequestMapping(
			value = "/search", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    ResponseEntity<Page<SearchResumeResponse>> searchResume(@Valid @RequestBody SearchResumeRequest searchResumeRequest, @RequestParam int pageNumber,  @RequestParam int pageSize);
	
	
}
