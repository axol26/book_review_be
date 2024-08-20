# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# EXPOSE 8080

# Use an official Maven image as the base image
FROM maven:3.9.4-eclipse-temurin-17-alpine AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests --no-transfer-progress

# # Use an official OpenJDK image as the base image
# FROM openjdk:11-jre-slim
# VOLUME /tmp
# # Set the working directory in the container
# WORKDIR /app
# # Copy the built JAR file from the previous stage to the container
# COPY --from=build /app/target/*.jar app.jar
# # Set the command to run the application
# CMD ["java", "-jar", "app.jar"]


FROM eclipse-temurin:22-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080