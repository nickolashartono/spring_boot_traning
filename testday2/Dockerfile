# Create the runtime image
FROM openjdk:21

WORKDIR /app

# Copy the JAR file from the build stage
COPY target/*.jar app.jar

# Expose the port your application listens on (e.g., 8080 for Spring Boot)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]