FROM ubuntu:latest

RUN apt-get update && apt-get install -y openjdk-11-jdk

WORKDIR /usr/local/bin/

ADD target/vacslots-app.jar .

ENTRYPOINT ["java", "-jar", "vacslots-app.jar"]