package com.resumebucket.resumes.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.repository.ResumeRepository;

@Component
public class ResumeDao {

	@Autowired
	private ResumeRepository resumeRepository;
	
	
	@CacheEvict(value = "resumes", allEntries = true) 
	public Resume save(Resume resume) {
		return resumeRepository.save(resume);
	}
	
	@CacheEvict(value = "resumes", allEntries = true) 
	public void deleteById(String resumeId) {
		resumeRepository.deleteById(resumeId);
	}
	
	@Cacheable(cacheNames = "resumes", unless="#result == null")
	public Optional<Resume> findById(String resumeId){
		return resumeRepository.findById(resumeId);
	}	
	
}
