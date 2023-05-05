FROM openjdk:17-jdk-slim-buster

COPY target/navigationservice.jar /opt/navigationservice.jar
ENTRYPOINT ["java", "-jar", "/opt/navigationservice.jar"]
