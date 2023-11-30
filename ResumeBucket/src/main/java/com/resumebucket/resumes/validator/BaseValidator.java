package com.resumebucket.resumes.validator;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.resumebucket.resumes.dao.ResumeDao;
import com.resumebucket.resumes.error.ResumeBucketException;
import com.resumebucket.resumes.repository.ResumeRepository;
import com.resumebucket.resumes.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseValidator {

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected ResumeRepository resumeRepository;
	
	@Autowired
	protected ResumeDao resumeDao;

	public void validateResumeId(String resumeId) {

		if (resumeDao.findById(resumeId).isEmpty()) {
			log.error("Resume not found. ResumeId:" + resumeId);
			throw new ResumeBucketException("Resume not found.");
		}

	}

	protected void validateStartAndEndDates(LocalDate startDate, LocalDate endDate) {

		if (startDate != null && endDate != null) {
			if (startDate.isAfter(endDate)) {
				log.error("StartDate cannot be after EndDate.");
				throw new ResumeBucketException("StartDate cannot be after EndDate.");
			}
		}

	}
}
