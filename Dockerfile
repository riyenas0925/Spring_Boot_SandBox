FROM openjdk:11
LABEL maintainer="riyenas0925@gmail.com"

ARG JAR_FILE=build/libs/gajiquiz-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} gaji-quiz.jar

ENTRYPOINT ["java","-jar","/gaji-quiz.jar"]