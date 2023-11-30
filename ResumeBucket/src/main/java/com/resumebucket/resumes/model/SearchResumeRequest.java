package com.resumebucket.resumes.model;

import java.io.Serializable;

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
public class SearchResumeRequest implements Serializable{

	private static final long serialVersionUID = -7961943412139826313L;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String searchText;
	
}
