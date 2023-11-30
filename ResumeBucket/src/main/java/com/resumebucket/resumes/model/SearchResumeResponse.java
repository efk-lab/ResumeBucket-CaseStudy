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
public class SearchResumeResponse implements Serializable {
	
	private static final long serialVersionUID = -6881875351241615063L;
	
	private String resumeId;
	
	private String firstName;
	
	private String lastName;


}
