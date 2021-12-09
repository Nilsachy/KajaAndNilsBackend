FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY backend.jar /
EXPOSE 8765:8765
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/backend.jar"]
EXPOSE 8765