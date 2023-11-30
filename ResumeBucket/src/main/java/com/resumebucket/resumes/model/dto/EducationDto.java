package com.resumebucket.resumes.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

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
public class EducationDto implements Serializable{

	private static final long serialVersionUID = -6027015732085297420L;

	@NotNull
	@NotBlank
	@NotEmpty
	private String schoolName;

	private String fieldOfStudy;

	private String degree;
	
	private LocalDate startDate;

	private LocalDate endDate;
}
