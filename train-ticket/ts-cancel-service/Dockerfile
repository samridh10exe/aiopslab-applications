FROM openjdk:8-jre-alpine

LABEL maintainer="TrainTicket F1 Fault Injection"

WORKDIR /app

COPY target/ts-cancel-service-1.0.jar app.jar

EXPOSE 18885

ENTRYPOINT ["java", "-jar", "app.jar"]
