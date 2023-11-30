package com.resumebucket.resumes.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DeleteResumeRequest implements Serializable {

	private static final long serialVersionUID = 8994754056815656602L;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String resumeId;

}
