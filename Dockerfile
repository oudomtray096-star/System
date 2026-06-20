# Use Java 17 (recommended for Spring Boot 3+)
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give permission to Maven wrapper
RUN chmod +x mvnw

# Build the project (skip tests for deployment)
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/*.jar"]