FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/Java-sb-mongodb01-0.0.1.jar /Java-sb-mongodb01-0.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "/Java-sb-mongodb01-0.0.1.jar"]