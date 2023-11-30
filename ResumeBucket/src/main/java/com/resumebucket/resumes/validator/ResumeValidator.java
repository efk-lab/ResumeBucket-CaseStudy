package com.resumebucket.resumes.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.resumebucket.resumes.error.ResumeBucketException;
import com.resumebucket.resumes.model.SaveResumeRequest;
import com.resumebucket.resumes.model.UpdateCertificatesRequest;
import com.resumebucket.resumes.model.UpdateEducationsRequest;
import com.resumebucket.resumes.model.UpdateExperiencesRequest;
import com.resumebucket.resumes.model.UpdateInterestsRequest;
import com.resumebucket.resumes.model.UpdateSkillsRequest;
import com.resumebucket.resumes.model.dto.CertificateDto;
import com.resumebucket.resumes.model.dto.EducationDto;
import com.resumebucket.resumes.model.dto.ExperienceDto;

@Component
public class ResumeValidator extends BaseValidator {
	
	public void validateSaveResumeRequest(SaveResumeRequest saveResumeRequest) throws ResumeBucketException {
		if(saveResumeRequest.getExperiences() != null) {
			validateExperiences(saveResumeRequest.getExperiences());
		}
		if(saveResumeRequest.getEducations() != null) {
			validateEducations(saveResumeRequest.getEducations());
		}
		if(saveResumeRequest.getCertificates() != null) {
			validateCertificates(saveResumeRequest.getCertificates());
		}
		if(saveResumeRequest.getSkills() != null) {
			validateSkills(saveResumeRequest.getSkills());
		}
		if(saveResumeRequest.getInterests() != null) {
			validateSkills(saveResumeRequest.getInterests());
		}
	}

	public void validateUpdateExperiencesRequest(UpdateExperiencesRequest updateExperiencesRequest) throws ResumeBucketException {
		validateResumeId(updateExperiencesRequest.getResumeId());
		validateExperiences(updateExperiencesRequest.getExperiences());

	}
	
	public void validateUpdateEducationsRequest(UpdateEducationsRequest updateEducationsRequest) throws ResumeBucketException {
		validateResumeId(updateEducationsRequest.getResumeId());
		validateEducations(updateEducationsRequest.getEducations());

	}

	public void validateUpdateCertificatesRequest(UpdateCertificatesRequest updateCertificatesRequest) throws ResumeBucketException {
		validateResumeId(updateCertificatesRequest.getResumeId());
		validateCertificates(updateCertificatesRequest.getCertificates());

	}
	
	public void validateUpdateSkillsRequest(UpdateSkillsRequest updateSkillsRequest) throws ResumeBucketException {
		validateResumeId(updateSkillsRequest.getResumeId());
		validateSkills(updateSkillsRequest.getSkills());
	}
	
	public void validateUpdateInterestsRequest(UpdateInterestsRequest updateInterestsRequest) throws ResumeBucketException {
		validateResumeId(updateInterestsRequest.getResumeId());
		validateInterests(updateInterestsRequest.getInterests());
	}
	
	private void validateExperiences(List<ExperienceDto> experiences) throws ResumeBucketException {
		experiences.stream().forEach(experience -> {
			try {
				validateStartAndEndDates(experience.getStartDate(), experience.getEndDate());
			} catch (ResumeBucketException e) {
				throw new ResumeBucketException("Experience[" + experiences.indexOf(experience) + "] : StartDate cannot be after EndDate. ");
			}
		});
	}

	private void validateEducations(List<EducationDto> educations) throws ResumeBucketException {
		educations.stream().forEach(education -> {
			try {
				validateStartAndEndDates(education.getStartDate(), education.getEndDate());
			} catch (ResumeBucketException e) {
				throw new ResumeBucketException("Education[" + educations.indexOf(education) + "] : StartDate cannot be after EndDate. ");
			}
		});
	}
	
	private void validateCertificates(List<CertificateDto> certificates) throws ResumeBucketException {
		certificates.stream().forEach(certificate -> {
			try {
				validateStartAndEndDates(certificate.getIssueDate(), certificate.getExpiryDate());
			} catch (ResumeBucketException e) {
				throw new ResumeBucketException("Certificate[" + certificates.indexOf(certificate) + "] : IssueDate cannot be after ExpiryDate.");
			}
		});
	}
	
	private void validateSkills(List<String> skills) throws ResumeBucketException {
		skills.stream().forEach(skill -> {
			if (skill == null || skill.isEmpty() || skill.isBlank()) {
				throw new ResumeBucketException("Skill[" + skills.indexOf(skill) + "] : Skill cannot be empty.");
			}
		});
	}

	private void validateInterests(List<String> interests) throws ResumeBucketException {
		interests.stream().forEach(interest -> {
			if (interest == null || interest.isEmpty() || interest.isBlank()) {
				throw new ResumeBucketException("Interest[" + interests.indexOf(interest) + "] : Interest cannot be empty.");
			}
		});
	}
}
