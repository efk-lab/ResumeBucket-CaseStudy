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
public class Contact implements Serializable {

	private static final long serialVersionUID = -4215130606673895146L;

	@Field(type = FieldType.Text, name = "firstName")
	private String firstName;

	@Field(type = FieldType.Text, name = "lastName")
	private String lastName;
	
	@Field(type = FieldType.Keyword, name = "phoneNumber")
	private String phoneNumber;

	@Field(type = FieldType.Keyword, name = "email")
	private String email;

	@Field(type = FieldType.Keyword, name = "city")
	private String city;

	@Field(type = FieldType.Keyword, name = "country")
	private String country;
}
