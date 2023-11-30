package com.resumebucket.resumes.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class SignUpRequest implements Serializable {

	private static final long serialVersionUID = -2440918365159261017L;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	
}
