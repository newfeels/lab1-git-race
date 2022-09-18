FROM openjdk:11
EXPOSE 8080
ADD build/libs/lab1-git-race-0.0.1-SNAPSHOT.jar /lab1-git-race-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/lab1-git-race-0.0.1-SNAPSHOT.jar"]