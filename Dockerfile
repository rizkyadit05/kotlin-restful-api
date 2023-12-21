FROM openjdk:21-jdk-slim
COPY build/libs/kotlin-restful-api-0.0.1-SNAPSHOT.jar /app/application.jar
WORKDIR /app
CMD ["java", "-jar", "application.jar"]