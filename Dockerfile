# ---------- Build Stage ----------
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---------- Run Stage ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Render uses port 10000 (NOT 100000)
EXPOSE 10000

ENTRYPOINT ["java", "-jar", "app.jar"]