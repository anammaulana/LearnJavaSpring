# FROM eclipse-temurin:21-jdk-alpine

# WORKDIR /app
# COPY target/*.jar app.jar
# ENTRYPOINT ["java", "-jar", "app.jar"]


# Gunakan image resmi OpenJDK 21
FROM openjdk:21-jdk-slim

# Set direktori kerja di dalam container
WORKDIR /app

# Salin file aplikasi jar ke dalam container
COPY target/*.jar /app/app.jar

# Jalankan aplikasi Spring Boot
CMD ["java", "-jar", "app.jar"]
