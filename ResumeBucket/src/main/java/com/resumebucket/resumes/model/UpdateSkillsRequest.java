package com.resumebucket.resumes.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class UpdateSkillsRequest extends UpdateResumeRequest implements Serializable {
	
	private static final long serialVersionUID = -6877044153821445454L;
	
	@NotNull
	@NotEmpty
	private List<String> skills;
	
}
