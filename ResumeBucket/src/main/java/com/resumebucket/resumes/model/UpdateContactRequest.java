package com.resumebucket.resumes.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.resumebucket.resumes.model.dto.ContactDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class UpdateContactRequest extends UpdateResumeRequest implements Serializable {

	private static final long serialVersionUID = 3594508576055574455L;
	
	@NotNull
	@Valid
	private ContactDto contact;
	
}
