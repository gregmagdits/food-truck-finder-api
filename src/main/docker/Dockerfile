FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ARG DB_PASSWORD
ENV foodtruck.db.password = ${DB_PASSWORD}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]