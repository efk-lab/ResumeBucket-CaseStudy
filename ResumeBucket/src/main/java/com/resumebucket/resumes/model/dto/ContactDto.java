package com.resumebucket.resumes.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
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
public class ContactDto implements Serializable {

	private static final long serialVersionUID = 6621182666438227557L;

	@NotNull
	@NotBlank
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String lastName;

	@NotNull
	@NotBlank
	@NotEmpty
	@Email
	private String email;
	
	private String phoneNumber;

	private String city;

	private String country;
}
