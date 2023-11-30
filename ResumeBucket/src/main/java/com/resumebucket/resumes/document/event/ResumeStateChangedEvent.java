package com.resumebucket.resumes.document.event;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.resumebucket.resumes.constant.ResumeStateChangedEventEventType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "resume_state_changed_event")
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class ResumeStateChangedEvent implements Serializable {

	private static final long serialVersionUID = 4041912101504839589L;

	@Id
	private String resumeStateChangedEventId;

	@Field(type = FieldType.Keyword, name = "resumeId")
	private String resumeId;

	@Field(type = FieldType.Keyword, name = "resumeStateChangedEventEventType")
	private ResumeStateChangedEventEventType resumeStateChangedEventEventType;

	@Field(type = FieldType.Date, name = "eventDate")
	private LocalDate eventDate;
	
}
