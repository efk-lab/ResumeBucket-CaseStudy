package com.resumebucket.resumes.model;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class SearchWhereTheyStudyResponse implements Serializable {
	
	private static final long serialVersionUID = -6082232061514637565L;

	private String schoolName;
	
	private int count;
	
}

	