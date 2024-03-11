FROM openjdk:17-alpine

#build된 jar 파일
ARG JAR_FILE_PATH=/session/build/libs

# 호스트의 JAR 파일을 컨테이너로 복사
COPY ${JAR_FILE_PATH}/session-0.0.1-SNAPSHOT.jar myboot.jar

ENTRYPOINT ["java", "-jar", "./myboot.jar"]
