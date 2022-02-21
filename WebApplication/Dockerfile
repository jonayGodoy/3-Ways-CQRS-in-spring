FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=/target/CQRS-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

#ENTRYPOINT Especifica el comando que se ejecuta cuando se inicia el contenedor de la ventana acoplable
## "- Djava.security.egd = file: / dev /./ urandom" Acelera el proceso de generación de números aleatorios
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

ENTRYPOINT ["java","-jar","/app.jar"]