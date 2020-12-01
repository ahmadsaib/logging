FROM openjdk:8-alpine
VOLUME /tmp
ADD target/log-0.0.1-SNAPSHOT.jar log-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","log-0.0.1-SNAPSHOT.jar"]