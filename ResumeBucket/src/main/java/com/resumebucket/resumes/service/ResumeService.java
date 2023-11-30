package com.resumebucket.resumes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resumebucket.resumes.dao.ResumeDao;
import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.mapper.ResumeMapper;
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
import com.resumebucket.resumes.validator.ResumeValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResumeService {

	@Autowired
	private ResumeMapper resumeMapper;

	@Autowired
	private ResumeDao resumeDao;
	
	@Autowired
	private ResumeValidator resumeValidator; 
	

	public SaveResumeResponse saveResume(SaveResumeRequest saveResumeRequest) {
		
		resumeValidator.validateSaveResumeRequest(saveResumeRequest);

		Resume resume = null;
		SaveResumeResponse saveResumeResponse = null;

		resume = resumeMapper.toResume(saveResumeRequest);
		saveResumeResponse = resumeMapper.toSaveResumeResponse(resumeDao.save(resume));

		log.info("Resume saved. SaveResumeResponse: " + saveResumeResponse.toString());

		return saveResumeResponse;
		
	}

	public GetResumeResponse getResume(GetResumeRequest getResumeRequest) {
		
		resumeValidator.validateResumeId(getResumeRequest.getResumeId());
		
		GetResumeResponse getResumeResponse = resumeMapper.toGetResumeResponse(resumeDao.findById(getResumeRequest.getResumeId()));

		log.info("Resume retrieved. GetResumeResponse: " + getResumeRequest.toString());

		return getResumeResponse;
		
	}

	public UpdateResumeResponse updateContact(UpdateContactRequest updateContactRequest) {
		
		resumeValidator.validateResumeId(updateContactRequest.getResumeId());
		
		Resume resume = resumeDao.findById(updateContactRequest.getResumeId()).get();
		
		resume.setContact(resumeMapper.toContact(updateContactRequest.getContact()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume contact updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
		
	}

	public UpdateResumeResponse updateSummary(UpdateSummaryRequest updateSummaryRequest) {
		
		resumeValidator.validateResumeId(updateSummaryRequest.getResumeId());
		
		Resume resume = resumeDao.findById(updateSummaryRequest.getResumeId()).get();
		
		resume.setSummary(updateSummaryRequest.getSummary());
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume summary updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateExperiences(UpdateExperiencesRequest updateExperiencesRequest) {
		resumeValidator.validateUpdateExperiencesRequest(updateExperiencesRequest);
		
		resumeValidator.validateUpdateExperiencesRequest(updateExperiencesRequest);
		
		Resume resume = resumeDao.findById(updateExperiencesRequest.getResumeId()).get();
		
		resume.setExperiences(resumeMapper.toExperiences(updateExperiencesRequest.getExperiences()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume experiences updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateEducations(UpdateEducationsRequest updateEducationsRequest) {
		
		resumeValidator.validateUpdateEducationsRequest(updateEducationsRequest);
		
		Resume resume = resumeDao.findById(updateEducationsRequest.getResumeId()).get();
		
		resume.setEducations(resumeMapper.toEducations(updateEducationsRequest.getEducations()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume educations updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateCertificates(UpdateCertificatesRequest updateCertificatesRequest) {
		
		resumeValidator.validateUpdateCertificatesRequest(updateCertificatesRequest);
		
		Resume resume = resumeDao.findById(updateCertificatesRequest.getResumeId()).get();
		
		resume.setCertificates(resumeMapper.toCertificates(updateCertificatesRequest.getCertificates()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume certificates updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateSkills(UpdateSkillsRequest updateSkillsRequest) {
		
		resumeValidator.validateUpdateSkillsRequest(updateSkillsRequest);
		
		Resume resume = resumeDao.findById(updateSkillsRequest.getResumeId()).get();
		
		resume.setSkills(updateSkillsRequest.getSkills());
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume skills updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateAwards(UpdateAwardsRequest updateAwardsRequest) {
		resumeValidator.validateResumeId(updateAwardsRequest.getResumeId());
		
		Resume resume = resumeDao.findById(updateAwardsRequest.getResumeId()).get();
		
		resume.setAwards(resumeMapper.toAwards(updateAwardsRequest.getAwards()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume awards updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateLanguages(UpdateLanguagesRequest updateLanguagesRequest) {
		
		resumeValidator.validateResumeId(updateLanguagesRequest.getResumeId());
		
		Resume resume = resumeDao.findById(updateLanguagesRequest.getResumeId()).get();
		
		resume.setLanguages(resumeMapper.toLanguages(updateLanguagesRequest.getLanguages()));
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume languages updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}

	public UpdateResumeResponse updateInterests(UpdateInterestsRequest updateInterestsRequest) {
		resumeValidator.validateUpdateInterestsRequest(updateInterestsRequest);
		
		Resume resume = resumeDao.findById(updateInterestsRequest.getResumeId()).get();
		
		resume.setInterests(updateInterestsRequest.getInterests());
	
		UpdateResumeResponse updateResumeResponse = resumeMapper.toUpdateResumeResponse(resumeDao.save(resume));

		log.info("Resume interests updated. UpdateResumeResponse: " + updateResumeResponse.toString());

		return updateResumeResponse;
	}
	
	public DeleteResumeResponse deleteResume(DeleteResumeRequest deleteResumeRequest) {
		
		resumeValidator.validateResumeId(deleteResumeRequest.getResumeId());
		
		resumeDao.deleteById(deleteResumeRequest.getResumeId());
				
		DeleteResumeResponse deleteResumeResponse =  resumeMapper.toDeleteResumeResponse(deleteResumeRequest);
		
		log.info("Resume deleted. DeleteResumeResponse: " + deleteResumeResponse.toString());
		
		return deleteResumeResponse;
	}

}
