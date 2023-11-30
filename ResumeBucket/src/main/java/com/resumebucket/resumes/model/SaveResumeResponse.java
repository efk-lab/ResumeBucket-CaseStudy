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
public class SaveResumeResponse implements Serializable {

	private static final long serialVersionUID = -7632114602926378541L;
	
	private String resumeId;
	
}
