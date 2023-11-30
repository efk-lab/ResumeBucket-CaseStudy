package com.resumebucket.resumes.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.resumebucket.resumes.constant.Role;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "user")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 4202748985343935560L;

	@Id
	private String userId;

	@Field(type = FieldType.Keyword, name = "email")
	private String email;

	@Field(type = FieldType.Text, name = "password")
	private String password;

	@Field(type = FieldType.Keyword, name = "role")
	private Role role;
	
}
