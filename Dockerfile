FROM eclipse-temurin:17
WORKDIR /app
COPY target/muj-unity-fest-2025-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
