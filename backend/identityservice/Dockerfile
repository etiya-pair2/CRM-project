FROM maven:3.9.9-sapmachine-23 as build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
FROM openjdk:23-jdk
COPY --from=build /app/target/identityservice-0.0.1-SNAPSHOT.jar /app/identityservice.jar
CMD ["java", "-jar", "/app/identityservice.jar","-Dspring-boot.run.arguments=--spring.config.location=classpath:/application-podman.properties"]
