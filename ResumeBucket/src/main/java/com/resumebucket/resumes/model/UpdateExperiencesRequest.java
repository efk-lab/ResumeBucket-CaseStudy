package com.resumebucket.resumes.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.resumebucket.resumes.model.dto.ExperienceDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class UpdateExperiencesRequest extends UpdateResumeRequest implements Serializable {
	
	private static final long serialVersionUID = 5218652034394552328L;
	
	@NotNull
	@NotEmpty
	@Valid
	private List<ExperienceDto>  experiences;
	
}
