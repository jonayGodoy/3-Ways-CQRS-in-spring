FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
COPY src/main/resources/prod-migrator-application-properties/application.properties /home/app/src/main/resources/application.properties
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip
 
FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY --from=build /home/app/target/Migrator-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]