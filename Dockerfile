# Multi-stage Dockerfile for building and running the Gradle Spring Boot application

# --- Builder stage ---------------------------------------------------------
FROM gradle:8.2.1-jdk17 AS builder
WORKDIR /home/gradle/project

# Copy project files (use gradle image user to leverage caching and permissions)
COPY --chown=gradle:gradle . .

# Build the fat jar (skip tests to speed up builds in the container)
RUN gradle bootJar --no-daemon -x test && \
    cp build/libs/*.jar app.jar


# --- Runtime stage ---------------------------------------------------------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy built jar from builder stage
COPY --from=builder /home/gradle/project/app.jar /app/app.jar

# Expose default Spring Boot port
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
