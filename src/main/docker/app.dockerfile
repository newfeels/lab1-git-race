#   Build options to create the container image.
#   In this project we are using java 11, and building
#   the app on 8080 port by default, then we import
#   the current libs that are used in this project.
#
#   Current snapshot: 0.0.1
#   syntax=docker/dockerfile:1
FROM openjdk:11
EXPOSE 8080
ADD build/libs/lab1-git-race-0.0.1-SNAPSHOT.jar /lab1-git-race-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/lab1-git-race-0.0.1-SNAPSHOT.jar"]
