# Etapa 1: build da aplicação
FROM gradle:8.13.0-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Etapa 2: imagem final para rodar o app
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]