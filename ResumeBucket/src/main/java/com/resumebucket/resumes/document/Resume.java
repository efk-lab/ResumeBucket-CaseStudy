package com.resumebucket.resumes.document;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "resume")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class Resume implements Serializable {
	
	private static final long serialVersionUID = -3614458825944054825L;

	@Id
	private String id;
	
	@Field(type = FieldType.Object, name = "contact") 
	private Contact contact;
	
	@Field(type = FieldType.Text, name = "summary")
	private String summary;

	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Experience> experiences;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Education> educations;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Certificate> certificates;
	
	@Field(type = FieldType.Text, name = "skills")
	private List<String> skills;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Award> awards;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Language> languages;
	
	@Field(type = FieldType.Text, name = "interests")
	private List<String> interests;

}
