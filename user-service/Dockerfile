# Use Amazon Corretto 24 JDK base image
FROM amazoncorretto:24-alpine

# Set work directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
