FROM adoptopenjdk/openjdk11
VOLUME /redis-service
ARG JAR_FILE=target/redis-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} redis-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/redis-service.jar"]
