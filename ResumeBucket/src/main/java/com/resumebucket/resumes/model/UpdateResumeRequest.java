package com.resumebucket.resumes.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateResumeRequest {
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String resumeId;

}
