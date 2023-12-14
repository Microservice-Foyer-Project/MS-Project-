FROM openjdk:17
EXPOSE 8082
ADD target/gestionChambre-0.0.1-SNAPSHOT.jar ChambreMS-docker.jar
ENTRYPOINT ["java", "-jar" ,"ChambreMS-docker.jar"]