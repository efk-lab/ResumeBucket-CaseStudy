package com.resumebucket.resumes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resumebucket.resumes.constant.ResumeStateChangedEventEventType;
import com.resumebucket.resumes.document.event.ResumeStateChangedEvent;
import com.resumebucket.resumes.model.DeleteResumeResponse;
import com.resumebucket.resumes.model.SaveResumeResponse;
import com.resumebucket.resumes.model.UpdateResumeResponse;
import com.resumebucket.resumes.repository.ResumeStateChangedEventRepository;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ResumeEventSourcingAspect {

	@Autowired
	private ResumeStateChangedEventRepository resumeStateChangedEventRepository;
	

	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.saveResume(..))", returning = "returnObject")
	public void saveResume(JoinPoint joinPoint, Object returnObject) {

		SaveResumeResponse saveResumeResponse = (SaveResumeResponse) returnObject;
	
		ResumeStateChangedEvent event = ResumeStateChangedEvent.builder()
																.resumeId(saveResumeResponse.getResumeId())
																.resumeStateChangedEventEventType(ResumeStateChangedEventEventType.RESUME_ADDED)
																.build();
		
		resumeStateChangedEventRepository.save(event);
		
		log.info("RESUME_ADDED event occured. Event: " + event.toString());

	}

	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateContact(..))", returning = "returnObject")
	public void updateContact(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_CONTACT_UPDATED);
		
	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateSummary(..))", returning = "returnObject")
	public void updateSummary(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateExperiences(..))", returning = "returnObject")
	public void updateExperiences(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateEducations(..))", returning = "returnObject")
	public void updateEducations(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateCertificates(..))", returning = "returnObject")
	public void updateCertificates(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateSkills(..))", returning = "returnObject")
	public void updateSkills(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateAwards(..))", returning = "returnObject")
	public void updateAwards(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateLanguages(..))", returning = "returnObject")
	public void updateLanguages(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.updateInterests(..))", returning = "returnObject")
	public void updateInterests(JoinPoint joinPoint, Object returnObject) {

		updateResume(returnObject, ResumeStateChangedEventEventType.RESUME_SUMMARY_UPDATED);

	}
	
	@AfterReturning(pointcut = "execution(* com.resumebucket.resumes.service.ResumeService.deleteResume(..))", returning = "returnObject")
	public void deleteResume(JoinPoint joinPoint, Object returnObject) {

		DeleteResumeResponse deleteResumeResponse = (DeleteResumeResponse) returnObject;
		
		
		ResumeStateChangedEvent event = ResumeStateChangedEvent.builder()
																.resumeId(deleteResumeResponse.getResumeId())
																.resumeStateChangedEventEventType(ResumeStateChangedEventEventType.RESUME_DELETED)
																.build();
		
		resumeStateChangedEventRepository.save(event);
		
		log.info("RESUME_DELETED event occured. Event: " + event.toString());

	}
	
	private void updateResume(Object returnObject, ResumeStateChangedEventEventType eventType) {
		
		UpdateResumeResponse updateResumeResponse = (UpdateResumeResponse) returnObject;
		
		
		ResumeStateChangedEvent event = ResumeStateChangedEvent.builder()
																.resumeId(updateResumeResponse.getResumeId())
																.resumeStateChangedEventEventType(eventType)
																.build();
		
		resumeStateChangedEventRepository.save(event);
		
		log.info(eventType.name() + " occured. Event: " + event.toString());

	}


}
