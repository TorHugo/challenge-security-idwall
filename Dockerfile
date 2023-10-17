FROM openjdk:17

WORKDIR  /app

COPY target/challenge_idwall-0.0.5-SNAPSHOT.jar /app/challenge_idwall-0.0.5-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/challenge_idwall-0.0.5-SNAPSHOT.jar"]