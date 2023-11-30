package com.resumebucket.resumes.controller.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resumebucket.resumes.ResumeBucketApplicationTest;
import com.resumebucket.resumes.model.SaveResumeRequest;
import com.resumebucket.resumes.model.SaveResumeResponse;
import com.resumebucket.resumes.service.ResumeService;

@ContextConfiguration(classes = {ResumeBucketApplicationTest.class})
@WebMvcTest(controllers = ResumeControllerImpl.class, excludeAutoConfiguration = ValidationAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(ResumeControllerImpl.class)
public class ResumeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ResumeService resumeService;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean 
	private LocalValidatorFactoryBean validator;

	@Test
	public void testSaveClassified() throws Exception {

		SaveResumeRequest saveResumeRequest = new SaveResumeRequest();
		SaveResumeResponse saveResumeResponse = SaveResumeResponse.builder().resumeId("122344444").build();

		given(resumeService.saveResume(any(SaveResumeRequest.class))).willReturn(saveResumeResponse);

		this.mockMvc.perform(post("/resumebucket/resume/registry")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(saveResumeRequest)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("resumeId").value("122344444"));
	}

}
