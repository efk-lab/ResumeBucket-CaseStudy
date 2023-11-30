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
public class Experience implements Serializable {

	private static final long serialVersionUID = 6304045058648799755L;

	@Field(type = FieldType.Keyword, name = "companyName")
	private String companyName;

	@Field(type = FieldType.Keyword, name = "title")
	private String title;
	
	@Field(type = FieldType.Date, name = "startDate")
	private LocalDate startDate;

	@Field(type = FieldType.Date, name = "endDate")
	private LocalDate endDate;

}
