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
public class CertificateDto implements Serializable{

	private static final long serialVersionUID = 1518406059809125515L;

	@NotNull
	@NotBlank
	@NotEmpty
	private String name;

	private String issuingOrganization;

	private LocalDate issueDate;

	private LocalDate expiryDate;
	
} 