FROM ubuntu:latest

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/

ADD target/vacslots-app.jar .

ENTRYPOINT ["java", "-jar", "simple-service.jar"]