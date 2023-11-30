package com.resumebucket.resumes.document;

import java.io.Serializable;

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
public class Language implements Serializable {

	private static final long serialVersionUID = -3482327604591754399L;

	@Field(type = FieldType.Keyword, name = "language")
	private String language;

	@Field(type = FieldType.Keyword, name = "proficiency")
	private String proficiency;

}

