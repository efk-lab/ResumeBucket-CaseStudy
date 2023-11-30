package com.resumebucket.resumes.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.resumebucket.resumes.model.DeleteResumeRequest;
import com.resumebucket.resumes.model.DeleteResumeResponse;
import com.resumebucket.resumes.model.GetResumeRequest;
import com.resumebucket.resumes.model.GetResumeResponse;
import com.resumebucket.resumes.model.SaveResumeRequest;
import com.resumebucket.resumes.model.SaveResumeResponse;
import com.resumebucket.resumes.model.UpdateAwardsRequest;
import com.resumebucket.resumes.model.UpdateCertificatesRequest;
import com.resumebucket.resumes.model.UpdateContactRequest;
import com.resumebucket.resumes.model.UpdateEducationsRequest;
import com.resumebucket.resumes.model.UpdateExperiencesRequest;
import com.resumebucket.resumes.model.UpdateInterestsRequest;
import com.resumebucket.resumes.model.UpdateLanguagesRequest;
import com.resumebucket.resumes.model.UpdateResumeResponse;
import com.resumebucket.resumes.model.UpdateSkillsRequest;
import com.resumebucket.resumes.model.UpdateSummaryRequest;

@RequestMapping("/resumebucket/resume")
public interface ResumeController {
	
	@RequestMapping(
			value = "/registry", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<SaveResumeResponse> saveResume(@Valid @RequestBody SaveResumeRequest saveResumeRequest);
	
	
	@RequestMapping(
			value = "/details", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    ResponseEntity<GetResumeResponse> getResume(@Valid @RequestBody GetResumeRequest getResumeRequest);
	
	
	@RequestMapping(
			value = "/contact", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateContact(@Valid @RequestBody UpdateContactRequest updateContactRequest);
	
	
	@RequestMapping(
			value = "/summary", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateSummary(@Valid @RequestBody UpdateSummaryRequest updateSummaryRequest);
	
	
	@RequestMapping(
			value = "/experiences", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateExperiences(@Valid @RequestBody UpdateExperiencesRequest updateExperiencesRequest);
	
	
	@RequestMapping(
			value = "/educations", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateEducations(@Valid @RequestBody UpdateEducationsRequest updateEducationsRequest);
	

	@RequestMapping(
			value = "/certificates", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateCertificates(@Valid @RequestBody UpdateCertificatesRequest updateCertificatesRequest);


	@RequestMapping(
			value = "/skills", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateSkills(@Valid @RequestBody UpdateSkillsRequest updateSkillsRequest);
	

	@RequestMapping(
			value = "/awards", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateAwards(@Valid @RequestBody UpdateAwardsRequest updateAwardstRequest);
	
	
	@RequestMapping(
			value = "/languages", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateLanguages(@Valid @RequestBody UpdateLanguagesRequest updateLanguagesRequest);
	
	
	@RequestMapping(
			value = "/interests", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAuthority('USER')")
    ResponseEntity<UpdateResumeResponse> updateInterests(@Valid @RequestBody UpdateInterestsRequest updateInterestsRequest);
	
	
	@RequestMapping(
			value = "/removal", 
			method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    ResponseEntity<DeleteResumeResponse> deleteResume(@Valid @RequestBody DeleteResumeRequest deleteResumeRequest);

}
