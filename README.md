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

# Deployment

- Install minikube
  - https://minikube.sigs.k8s.io/docs/start/

- For loadbanacer run command below
  > minikube tunnel
  
- Deploy Elastic-Stack
  >kubectl apply -f elastic-stack.yaml

- Deploy Redis-Stack
  >kubectl apply -f redis-stack.yaml
   
- Build Image
  > docker build -t resumebucket:latest -f /eclipse-workspace/ResumeBucket/src/main/resources/Dockerfile .
  
  > eval $(minikube docker-env)
  
- Deploy Applications
  > kubectl apply -f resumebucket.yaml
  
- Kubernetes Dashboard
  > minikube dasboard
  
- Prometheus&Grafana
  > kubectl create namespace monitoring
