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
public class Award implements Serializable {
	
	private static final long serialVersionUID = -6716756135640710211L;

	@Field(type = FieldType.Text, name = "title")
	private String title;

	@Field(type = FieldType.Text, name = "description")
	private String description;
	
	@Field(type = FieldType.Keyword, name = "issuer")
	private String issuer;

	@Field(type = FieldType.Date, name = "issueDate")
	private LocalDate issueDate;

	
}

