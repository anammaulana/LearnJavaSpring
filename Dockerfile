# Gunakan base image Java
FROM openjdk:17-jdk-slim

# Tambahkan jar ke image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Jalankan aplikasi
ENTRYPOINT ["java","-jar","/app.jar"]
