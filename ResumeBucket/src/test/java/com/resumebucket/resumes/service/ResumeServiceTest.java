package com.resumebucket.resumes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.resumebucket.resumes.dao.ResumeDao;
import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.mapper.ResumeMapper;
import com.resumebucket.resumes.model.SaveResumeRequest;
import com.resumebucket.resumes.model.SaveResumeResponse;
import com.resumebucket.resumes.validator.ResumeValidator;

@ExtendWith(MockitoExtension.class)
public class ResumeServiceTest {
	
	@Mock
	private ResumeMapper resumeMapper;

	@Mock
	private ResumeDao resumeDao;
	
	@Mock
	private ResumeValidator resumeValidator; 
	
	@InjectMocks
	private ResumeService resumeService;
	

	@Test
	public void testSaveResume() throws Exception {
		SaveResumeRequest saveResumeRequest = new SaveResumeRequest(); 
		SaveResumeResponse saveResumeResponseExpected = SaveResumeResponse.builder().resumeId("asdff12334").build();
		Resume resume = Resume.builder().id("asdff12334").build();

		doNothing().when(resumeValidator).validateSaveResumeRequest(saveResumeRequest);
		given(resumeMapper.toResume(any(SaveResumeRequest.class))).willReturn(resume);
		given(resumeDao.save(any(Resume.class))).willReturn(resume);
		given(resumeMapper.toSaveResumeResponse(any(Resume.class))).willReturn(saveResumeResponseExpected);

		SaveResumeResponse saveResumeResponseActual = resumeService.saveResume(saveResumeRequest);

		assertThat(saveResumeResponseActual.getResumeId()).isEqualTo(saveResumeResponseExpected.getResumeId());
	}

}