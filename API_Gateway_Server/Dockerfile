FROM openjdk:11
EXPOSE 8090
ADD target/API_Gateway_Server-0.0.1-SNAPSHOT.jar Gateway-docker.jar
ENTRYPOINT ["java", "-jar", "Gateway-docker.jar"]
