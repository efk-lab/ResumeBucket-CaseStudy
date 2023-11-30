# ResumeBucket-CaseStudy
ResumeBucket is a rest api for an online resume storage.

# Tech Stack

Java11, Spring Boot(web, test, data-redis, security, log4j2, cache, validation, aop), Spring Data Elasticsearch, Spring Security Oauth2, Elasticsearch, Redis, REST, Maven, Junit5, Mockito, Assertj, Kubernetes

# Rest API

- UserRegistryController : Restfull Service for user registry
  - signUp

- ResumeController : Restfull Service for resume operations.
  - saveResume
  - getResume 
  - updateContact 
  - updateSummary
  - updateExperiences
  - updateEducations
  - updateCertificates
  - updateSkills
  - updateAwards
  - updateLanguages
  - updateInterests
  - deleteResume

- ResumeSearchController : Restfull Service for resume search operations.
  - searchResume

- ResumeStatisticsController : Restfull Service for resume statistics operations.
  - searchWhereTheyLive
  - searchWhereTheyStudy

