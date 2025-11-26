# Imagen base de Java 21 (compatible con Spring Boot 3.5.x)
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copiamos el proyecto completo
COPY . .

# Damos permisos a mvnw
RUN chmod +x mvnw

# Construimos el JAR sin test
RUN ./mvnw clean package -DskipTests

# Etapa final
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el jar generado
COPY --from=builder /app/target/edificando-web-api-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
