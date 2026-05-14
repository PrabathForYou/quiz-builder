FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app

COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code from current directory
COPY . .

# Build Spring Boot application
RUN mvn clean package -DskipTests

# -----------------------------
# Stage 2 - Run Application
# -----------------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Optional timezone
ENV TZ=Asia/Colombo

# Read Spring profile from environment variable
ENV SPRING_PROFILES_ACTIVE=default

# Application port from application.properties
# Override when running container if needed
ENV SERVER_PORT=9090

# Copy built jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE ${SERVER_PORT}

# Run Spring Boot app
ENTRYPOINT ["sh", "-c", "java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -Dserver.port=${SERVER_PORT} app.jar"]