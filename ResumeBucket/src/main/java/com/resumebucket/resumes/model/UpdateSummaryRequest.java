package com.resumebucket.resumes.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class UpdateSummaryRequest extends UpdateResumeRequest implements Serializable {
	
	private static final long serialVersionUID = 4682485270844591219L;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(max=500)
	private String summary;
	
}
