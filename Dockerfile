FROM openjdk:17-jdk-alpine

COPY target/gestionFoyer-1.jar gestionFoyer-1.jar

ENTRYPOINT ["java","-jar","/app.jar"]