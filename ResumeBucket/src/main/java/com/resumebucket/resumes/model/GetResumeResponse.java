package com.resumebucket.resumes.model;

import java.io.Serializable;
import java.util.List;

import com.resumebucket.resumes.model.dto.AwardDto;
import com.resumebucket.resumes.model.dto.CertificateDto;
import com.resumebucket.resumes.model.dto.ContactDto;
import com.resumebucket.resumes.model.dto.EducationDto;
import com.resumebucket.resumes.model.dto.ExperienceDto;
import com.resumebucket.resumes.model.dto.LanguageDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class GetResumeResponse implements Serializable {
	
	private static final long serialVersionUID = -6782239148803043252L;

	private String resumeId;

	private ContactDto contact;

	private String summary;

	private List<ExperienceDto> experiences;
	
	private List<EducationDto> educations;

	private List<CertificateDto> certificates;
	
	private List<String> skills;

	private List<AwardDto> awards;

	private List<LanguageDto> languages;
	
	private List<String> interests;

}
