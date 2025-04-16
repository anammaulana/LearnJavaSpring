FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]


# FROM eclipse-temurin:21-jdk-alpine
# WORKDIR /app
# COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]

# FROM openjdk:21-jdk-slim
# WORKDIR /app
# COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
# CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]



# # Gunakan image resmi OpenJDK 21
# FROM openjdk:21-jdk-slim

# # Set direktori kerja di dalam container
# WORKDIR /app

# # Salin file aplikasi jar ke dalam container
# COPY target/*.jar /app/app.jar

# # Jalankan aplikasi Spring Boot
# CMD ["java", "-jar", "app.jar"]
