
FROM openjdk:17-jdk
LABEL authors="SSAFY"
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} docker-springboot.jar
ENTRYPOINT ["java","-jar","/docker-springboot.jar"]