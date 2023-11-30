package com.resumebucket.resumes.document;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class Certificate implements Serializable {
	
	private static final long serialVersionUID = -7606821810203691282L;

	@Field(type = FieldType.Text, name = "name")
	private String name;

	@Field(type = FieldType.Keyword, name = "issuingOrganization")
	private String issuingOrganization;

	@Field(type = FieldType.Date, name = "issueDate")
	private LocalDate issueDate;

	@Field(type = FieldType.Date, name = "expiryDate")
	private LocalDate expiryDate;
	
} 