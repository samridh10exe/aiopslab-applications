FROM openjdk:8-jre-alpine

LABEL maintainer="TrainTicket F1 Fault Injection"

WORKDIR /app

COPY target/ts-inside-payment-service-1.0.jar app.jar

EXPOSE 18673

ENTRYPOINT ["java", "-jar", "app.jar"]
