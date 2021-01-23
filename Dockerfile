# Install Java
# Docker file for two phase build
# Phase 1 - Build the application .jar file and name it builder
#Try alpine slim jdk
FROM adoptopenjdk/openjdk11:alpine-slim as builder
#FROM openjdk:11.0-jdk-slim as builder
VOLUME /tmp
COPY . .
RUN sed -i.bak 's/\r$//g' ./gradlew 
RUN ./gradlew build

# Phase 2 - Build container with runtime only to use .jar file within
FROM openjdk:11.0-jre-slim
WORKDIR /app
# Copy .jar file (aka, builder)
COPY --from=builder build/libs/*.jar guestbook-0.0.1-SNAPSHOT.jar
CMD [ "sh", "-c", "java -Xmx300m -Xss512k -Dserver.port=$PORT $JAVA_OPTS -jar /app/guestbook-0.0.1-SNAPSHOT.jar" ]
