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
public class Education implements Serializable {
	
	private static final long serialVersionUID = 2938823720295921019L;

	@Field(type = FieldType.Keyword, name = "schoolName")
	private String schoolName;

	@Field(type = FieldType.Keyword, name = "fieldOfStudy")
	private String fieldOfStudy;
	
	@Field(type = FieldType.Keyword, name = "degree")
	private String degree;
	
	@Field(type = FieldType.Date, name = "startDate")
	private LocalDate startDate;

	@Field(type = FieldType.Date, name = "endDate")
	private LocalDate endDate;
}
