package com.resumebucket.resumes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;

import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.model.SearchResumeRequest;
import com.resumebucket.resumes.model.SearchWhereTheyLiveResponse;
import com.resumebucket.resumes.model.SearchWhereTheyStudyResponse;

public interface ResumeRepositoryCustom {

//	public Resume updateContact(UpdateContactRequest updateContactRequest);
//	
//	public Resume updateSummary(UpdateSummaryRequest updateSummaryRequest);
//	
//	public Resume updateExperiences(UpdateExperiencesRequest updateExperiencesRequest);
//	
//	public Resume updateEducations(UpdateEducationsRequest updateEducationsRequest);
//	
//	public Resume updateCertificates(UpdateCertificatesRequest updateCertificatesRequest);
//	
//	public Resume updateSkills(UpdateSkillsRequest updateSkillsRequest);
//	
//	public Resume updateAwards(UpdateAwardsRequest updateAwardsRequest);
//	
//	public Resume updateLanguages(UpdateLanguagesRequest updateLanguagesRequest);
//	
//	public Resume updateInterests(UpdateInterestsRequest updateInterestsRequest);
	
	
	SearchPage<Resume> searchResume(SearchResumeRequest searchResumeRequest, Pageable pageable);
	
	Page<SearchWhereTheyLiveResponse> searchWhereTheyLive(Pageable pageable);
	
	Page<SearchWhereTheyStudyResponse> searchWhereTheyStudy(Pageable pageable);

}
