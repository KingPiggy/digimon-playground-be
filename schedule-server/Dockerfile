# Use the official OpenJDK base image
FROM openjdk:11-jdk

# Copy the packaged Spring Boot application JAR file into the container at /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

# Run the Spring Boot application when the container launches
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","./app/app.jar"]
