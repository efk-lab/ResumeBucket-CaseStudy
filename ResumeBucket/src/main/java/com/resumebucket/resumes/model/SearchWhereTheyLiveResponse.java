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
public class SearchWhereTheyLiveResponse implements Serializable {
	
	private static final long serialVersionUID = 9204131869752905537L;
	
	private String city;
	
	private int count;
	
}

	