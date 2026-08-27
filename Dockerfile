# ETAPA 1: Compilación (Build)
# Usamos una imagen que ya tiene Maven y Java instalados
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copiamos el archivo de configuración de Maven y el código fuente
COPY pom.xml .
COPY src ./src

# Ejecutamos la compilación dentro de Docker para generar el JAR
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecución (Run)
# Usamos una imagen de Java más ligera para correr la app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copiamos el JAR generado en la etapa anterior (la de "build")
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]