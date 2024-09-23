# Base image olarak OpenJDK kullan
FROM openjdk:17-jdk-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Uygulama dosyalarını kopyala
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
