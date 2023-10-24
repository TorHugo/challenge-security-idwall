FROM openjdk:17

WORKDIR  /app

COPY target/challenge_idwall-1.0.4.jar /app/challenge_idwall-1.0.4.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/challenge_idwall-1.0.4.jar"]