FROM maven:3.8.4-openjdk-17-slim AS build
COPY src /home/app/src
#COPY src/main/resources/prod-web-application-properties/application.properties /home/app/src/main/resources/application.properties
COPY pom.xml /home/app
RUN mvn install:install-file -Dfile=/home/app/src/main/java/lib/ShareKernel.jar -DgroupId=com.shareKernel -DartifactId=shareKernel -Dversion=1.0  -Dpackaging=jar -DgeneratePom=true
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip
 
FROM openjdk:17-jdk-alpine
COPY --from=build /home/app/target/CQRS-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]