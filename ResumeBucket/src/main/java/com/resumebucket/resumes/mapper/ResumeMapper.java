package com.resumebucket.resumes.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.resumebucket.resumes.document.Award;
import com.resumebucket.resumes.document.Certificate;
import com.resumebucket.resumes.document.Contact;
import com.resumebucket.resumes.document.Education;
import com.resumebucket.resumes.document.Experience;
import com.resumebucket.resumes.document.Language;
import com.resumebucket.resumes.document.Resume;
import com.resumebucket.resumes.model.DeleteResumeRequest;
import com.resumebucket.resumes.model.DeleteResumeResponse;
import com.resumebucket.resumes.model.GetResumeResponse;
import com.resumebucket.resumes.model.SaveResumeRequest;
import com.resumebucket.resumes.model.SaveResumeResponse;
import com.resumebucket.resumes.model.UpdateResumeResponse;
import com.resumebucket.resumes.model.dto.AwardDto;
import com.resumebucket.resumes.model.dto.CertificateDto;
import com.resumebucket.resumes.model.dto.ContactDto;
import com.resumebucket.resumes.model.dto.EducationDto;
import com.resumebucket.resumes.model.dto.ExperienceDto;
import com.resumebucket.resumes.model.dto.LanguageDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResumeMapper {

	
	public Resume toResume(SaveResumeRequest saveResumeRequest) {

		log.info("Mapping SaveResumeRequest to Resume. SaveResumeRequest:" + saveResumeRequest.toString());
		
		return Resume.builder()
						.contact(toContact(saveResumeRequest.getContact()))
						.summary(saveResumeRequest.getSummary())
						.skills(saveResumeRequest.getSkills())
						.interests(saveResumeRequest.getInterests())
						.experiences(toExperiences(saveResumeRequest.getExperiences()))
						.educations(toEducations(saveResumeRequest.getEducations()))
						.certificates(toCertificates(saveResumeRequest.getCertificates()))
						.awards(toAwards(saveResumeRequest.getAwards()))
						.languages(toLanguages(saveResumeRequest.getLanguages()))
						.build();		   
	}

	public Contact toContact(ContactDto contactDto) {
		
		log.info("Mapping ContactDto to Contact. ContactDto:" + contactDto.toString());
		
		return Contact.builder()
						.firstName(contactDto.getFirstName())
						.lastName(contactDto.getLastName())
						.phoneNumber(contactDto.getPhoneNumber())
						.email(contactDto.getEmail())
						.city(contactDto.getCity())
						.country(contactDto.getCountry())
						.build();		   
	}
	
	
	public List<Experience> toExperiences(List<ExperienceDto> experienceDtoList) {
		
		log.info("Mapping ContactDto list to Experience list. experienceDtoList:" + experienceDtoList.toString());
		
		List<Experience> experiences = new ArrayList<Experience>();
		
		experienceDtoList.stream().forEach(experience -> experiences.add(Experience.builder()
																					.companyName(experience.getCompanyName())
																					.title(experience.getTitle())
																					.startDate(experience.getStartDate())
																					.endDate(experience.getEndDate())
																					.build()));
		return experiences;
	}

	public List<Education> toEducations(List<EducationDto> educationDtoList ) {
		
		log.info("Mapping EducationDto list to Education list. educationDtoList:" + educationDtoList.toString());
		
		List<Education> educations = new ArrayList<Education>();
		
		educationDtoList.stream().forEach(education -> educations.add(Education.builder()
																				.schoolName(education.getSchoolName())
																				.fieldOfStudy(education.getFieldOfStudy())
																				.degree(education.getDegree())
																				.startDate(education.getStartDate())
																				.endDate(education.getEndDate())
																				.build()));
		return educations;
	}
	
	public List<Certificate> toCertificates(List<CertificateDto> certificateDtoList) {
		
		log.info("Mapping CertificateDto list to Certificate list. certificateDtoList:" + certificateDtoList.toString());
		
		List<Certificate> certificates = new ArrayList<Certificate>();
		
		certificateDtoList.stream().forEach(certificate -> certificates.add(Certificate.builder()
																						.name(certificate.getName())
																						.issuingOrganization(certificate.getIssuingOrganization())
																						.issueDate(certificate.getIssueDate())
																						.expiryDate(certificate.getExpiryDate())
																						.build()));
		return certificates;
	}
	
	public List<Award> toAwards(List<AwardDto> awardDtoList) {
		
		log.info("Mapping AwardDto list to Award list. awardDtoList:" + awardDtoList.toString());
		
		List<Award> awards = new ArrayList<Award>();
		
		awardDtoList.stream().forEach(award -> awards.add(Award.builder()
																.title(award.getTitle())
																.description(award.getDescription())
																.issuer(award.getIssuer())
																.issueDate(award.getIssueDate())
																.build()));
		return awards;
	}
	
	public List<Language> toLanguages(List<LanguageDto> languageDtoList) {
		
		log.info("Mapping LanguageDto list to Language list. languageDtoList:" + languageDtoList.toString());
		
		List<Language> languages = new ArrayList<Language>();
		
		languageDtoList.stream().forEach(language -> languages.add(Language.builder()
																			.language(language.getLanguage())
																			.proficiency(language.getProficiency())
																			.build()));
		return languages;
	}
	
	public SaveResumeResponse toSaveResumeResponse(Resume resume) {
		
		log.info("Mapping Resume to SaveResumeResponse. Resume:" + resume.toString());
		
		return SaveResumeResponse.builder()
									.resumeId(resume.getId())
									.build();
	}
	
	public GetResumeResponse toGetResumeResponse(Optional<Resume> resume) {
		
		Resume retrievedResume = resume.orElse(null);
		
		if(retrievedResume != null) {
			
			log.info("Mapping Resume to GetResumeResponse. Resume:" + retrievedResume.toString());
			
			return GetResumeResponse.builder()
									.resumeId(retrievedResume.getId())
									.contact(toContactDto(retrievedResume.getContact()))
									.summary(retrievedResume.getSummary())
									.skills(retrievedResume.getSkills())
									.interests(retrievedResume.getInterests())
									.experiences(toExperienceDto(retrievedResume.getExperiences()))
									.educations(toEducationDto(retrievedResume.getEducations()))
									.certificates(toCertificateDto(retrievedResume.getCertificates()))
									.awards(toAwardDto(retrievedResume.getAwards()))
									.languages(toLanguageDto(retrievedResume.getLanguages()))
									.build();		   
		} 
		
		return null;
		
	}
	
	public ContactDto toContactDto(Contact contact) {
		
		log.info("Mapping Contact to ContactDto. Contact:" + contact.toString());
		
		return ContactDto.builder()
							.firstName(contact.getFirstName())
							.lastName(contact.getLastName())
							.phoneNumber(contact.getPhoneNumber())
							.email(contact.getEmail())
							.city(contact.getCity())
							.country(contact.getCountry())
							.build();		   
	}
	
	public List<ExperienceDto> toExperienceDto(List<Experience> experienceList) {
		
		log.info("Mapping Experience list to ExperienceDto list. experienceList:" + experienceList.toString());
		
		List<ExperienceDto> experiences = new ArrayList<ExperienceDto>();
		
		experienceList.stream().forEach(experience -> experiences.add(ExperienceDto.builder()
																					.companyName(experience.getCompanyName())
																					.title(experience.getTitle())
																					.startDate(experience.getStartDate())
																					.endDate(experience.getEndDate())
																					.build()));
		return experiences;
	}

	public List<EducationDto> toEducationDto(List<Education> educationList) {
		
		log.info("Mapping Education list to EducationDto list. educationList:" + educationList.toString());
		
		List<EducationDto> educations = new ArrayList<EducationDto>();
		
		educationList.stream().forEach(education -> educations.add(EducationDto.builder()
																				.schoolName(education.getSchoolName())
																				.fieldOfStudy(education.getFieldOfStudy())
																				.degree(education.getDegree())
																				.startDate(education.getStartDate())
																				.endDate(education.getEndDate())
																				.build()));
		return educations;
	}
	
	public List<CertificateDto> toCertificateDto(List<Certificate> certificateList) {
		
		log.info("Mapping Certificate list to CertificateDto list. certificateList:" + certificateList.toString());
		
		List<CertificateDto> certificates = new ArrayList<CertificateDto>();
		
		certificateList.stream().forEach(certificate -> certificates.add(CertificateDto.builder()
																						.name(certificate.getName())
																						.issuingOrganization(certificate.getIssuingOrganization())
																						.issueDate(certificate.getIssueDate())
																						.expiryDate(certificate.getExpiryDate())
																						.build()));
		return certificates;
	}
	
	public List<AwardDto> toAwardDto(List<Award> awardList) {
		
		log.info("Mapping Award list to AwardDto list. awardList:" + awardList.toString());
		
		List<AwardDto> awards = new ArrayList<AwardDto>();
		
		awardList.stream().forEach(award -> awards.add(AwardDto.builder()
																.title(award.getTitle())
																.description(award.getDescription())
																.issuer(award.getIssuer())
																.issueDate(award.getIssueDate())
																.build()));
		return awards;
	}
	
	public List<LanguageDto> toLanguageDto(List<Language> languageList) {
		
		log.info("Mapping Language list to LanguageDto list. languageList:" + languageList.toString());
		
		List<LanguageDto> languages = new ArrayList<LanguageDto>();
		
		languageList.stream().forEach(language -> languages.add(LanguageDto.builder()
																			.language(language.getLanguage())
																			.proficiency(language.getProficiency())
																			.build()));
		return languages;
	}
	
	public UpdateResumeResponse toUpdateResumeResponse(Resume resume){
		
		log.info("Mapping Resume to UpdateResumeResponse. Resume:" + resume.toString());
		
		return UpdateResumeResponse.builder()
									.resumeId(resume.getId())
									.build();
	}
	
	public DeleteResumeResponse toDeleteResumeResponse(DeleteResumeRequest deleteResumeRequest) {
		
		log.info("Mapping DeleteResumeResponse. DeleteResumeRequest:" + deleteResumeRequest.toString());
		
		return DeleteResumeResponse.builder()
									.resumeId(deleteResumeRequest.getResumeId())
									.build();
	}
	
}
