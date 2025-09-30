# Stage 1: Build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar doctor-service.jar

# Pass environment variables at runtime (from .env)
ENTRYPOINT ["java","-jar","doctor-service.jar"]
