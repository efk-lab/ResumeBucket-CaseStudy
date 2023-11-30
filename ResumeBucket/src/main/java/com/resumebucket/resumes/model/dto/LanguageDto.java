package com.resumebucket.resumes.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class LanguageDto implements Serializable {

	private static final long serialVersionUID = -6439639268155349105L;

	@NotNull
	@NotBlank
	@NotEmpty
	private String language;

	private String proficiency;

}

