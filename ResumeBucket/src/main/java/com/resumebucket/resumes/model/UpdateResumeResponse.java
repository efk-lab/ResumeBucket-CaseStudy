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
public class UpdateResumeResponse implements Serializable {
	
	private static final long serialVersionUID = -3435495906654825780L;
	
	private String resumeId;
	
}
