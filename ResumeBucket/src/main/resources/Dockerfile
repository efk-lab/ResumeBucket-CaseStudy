FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} resumebucket.jar
ENTRYPOINT ["java","-jar","/resumebucket.jar"]