package com.resumebucket.resumes.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.resumebucket.resumes.model.dto.AwardDto;
import com.resumebucket.resumes.model.dto.CertificateDto;
import com.resumebucket.resumes.model.dto.ContactDto;
import com.resumebucket.resumes.model.dto.EducationDto;
import com.resumebucket.resumes.model.dto.ExperienceDto;
import com.resumebucket.resumes.model.dto.LanguageDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class SaveResumeRequest implements Serializable {

	private static final long serialVersionUID = 4774976001157596379L;
	
	@NotNull
	@Valid
	private ContactDto contact;

	@Size(max=500)
	private String summary;
	
	@Valid
	private List<ExperienceDto> experiences;
	
	@Valid
	private List<EducationDto> educations;
	
	@Valid
	private List<CertificateDto> certificates;
	
	@Valid
	private List<String> skills;
	
	@Valid
	private List<AwardDto> awards;
	
	@Valid
	private List<LanguageDto> languages;
	
	@Valid
	private List<String> interests;
	
}
