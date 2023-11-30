package com.resumebucket.resumes.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.resumebucket.resumes.controller.ResumeController;
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
import com.resumebucket.resumes.service.ResumeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResumeControllerImpl implements ResumeController {

	@Autowired
	private ResumeService resumeService;
	

	@Override
	public ResponseEntity<SaveResumeResponse> saveResume(SaveResumeRequest saveResumeRequest) {
		log.info("SaveBookRequest received: " + saveResumeRequest.toString());

		SaveResumeResponse saveResumeResponse = resumeService.saveResume(saveResumeRequest);

		if (saveResumeResponse != null) {
			return new ResponseEntity<>(saveResumeResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(saveResumeResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<GetResumeResponse> getResume(GetResumeRequest getResumeRequest) {
		log.info("GetResumeRequest received: " + getResumeRequest.toString());

		GetResumeResponse getResumeResponse = resumeService.getResume(getResumeRequest);

		if (getResumeResponse != null) {
			return new ResponseEntity<>(getResumeResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(getResumeResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateContact(@Valid UpdateContactRequest updateContactRequest) {
		log.info("UpdateContactRequest received: " + updateContactRequest.toString());

		UpdateResumeResponse updateContactResponse = resumeService.updateContact(updateContactRequest);

		if (updateContactResponse != null) {
			return new ResponseEntity<>(updateContactResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateContactResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateSummary(@Valid UpdateSummaryRequest updateSummaryRequest) {
		log.info("UpdateContactRequest received: " + updateSummaryRequest.toString());

		UpdateResumeResponse updateSummaryResponse = resumeService.updateSummary(updateSummaryRequest);

		if (updateSummaryResponse != null) {
			return new ResponseEntity<>(updateSummaryResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateSummaryResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateExperiences(@Valid UpdateExperiencesRequest updateExperiencesRequest) {

		log.info("UpdateExperiencesRequest received: " + updateExperiencesRequest.toString());

		UpdateResumeResponse updateExperiencesResponse = resumeService.updateExperiences(updateExperiencesRequest);

		if (updateExperiencesResponse != null) {
			return new ResponseEntity<>(updateExperiencesResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateExperiencesResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateEducations(@Valid UpdateEducationsRequest updateEducationsRequest) {
		log.info("UpdateEducationsRequest received: " + updateEducationsRequest.toString());

		UpdateResumeResponse updateEducationsResponse = resumeService.updateEducations(updateEducationsRequest);

		if (updateEducationsResponse != null) {
			return new ResponseEntity<>(updateEducationsResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateEducationsResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateCertificates(@Valid UpdateCertificatesRequest updateCertificatesRequest) {
		log.info("UpdateCertificatesRequest received: " + updateCertificatesRequest.toString());

		UpdateResumeResponse updateCertificatesResponse = resumeService.updateCertificates(updateCertificatesRequest);

		if (updateCertificatesResponse != null) {
			return new ResponseEntity<>(updateCertificatesResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateCertificatesResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateSkills(@Valid UpdateSkillsRequest updateSkillsRequest) {
		log.info("UpdateSkillsRequest received: " + updateSkillsRequest.toString());

		UpdateResumeResponse updateSkillsResponse = resumeService.updateSkills(updateSkillsRequest);

		if (updateSkillsResponse != null) {
			return new ResponseEntity<>(updateSkillsResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateSkillsResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateAwards(@Valid UpdateAwardsRequest updateAwardstRequest) {
		log.info("UpdateAwardsRequest received: " + updateAwardstRequest.toString());

		UpdateResumeResponse updateAwardsResponse = resumeService.updateAwards(updateAwardstRequest);

		if (updateAwardsResponse != null) {
			return new ResponseEntity<>(updateAwardsResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateAwardsResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateLanguages(@Valid UpdateLanguagesRequest updateLanguagesRequest) {
		log.info("UpdateLanguagesRequest received: " + updateLanguagesRequest.toString());

		UpdateResumeResponse updateLanguagesResponse = resumeService.updateLanguages(updateLanguagesRequest);

		if (updateLanguagesResponse != null) {
			return new ResponseEntity<>(updateLanguagesResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateLanguagesResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<UpdateResumeResponse> updateInterests(@Valid UpdateInterestsRequest updateInterestsRequest) {
		log.info("UpdateInterestsRequest received: " + updateInterestsRequest.toString());

		UpdateResumeResponse updateInterestsResponse = resumeService.updateInterests(updateInterestsRequest);

		if (updateInterestsResponse != null) {
			return new ResponseEntity<>(updateInterestsResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(updateInterestsResponse, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<DeleteResumeResponse> deleteResume(@Valid DeleteResumeRequest deleteResumeRequest) {
		log.info("DeleteResumeRequest received: " + deleteResumeRequest.toString());

		DeleteResumeResponse deleteResumeResponse = resumeService.deleteResume(deleteResumeRequest);

		if (deleteResumeResponse != null) {
			return new ResponseEntity<>(deleteResumeResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(deleteResumeResponse, HttpStatus.NO_CONTENT);
		}
	}

}
