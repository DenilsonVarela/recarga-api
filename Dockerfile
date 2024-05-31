#FROM ubuntu:latest
#LABEL authors="maedu"

#ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-slim

# Instala o git
RUN apt-get update && apt-get install -y git

# Clona o repositório do wait-for-it
RUN git clone https://github.com/vishnubob/wait-for-it.git

COPY target/RestAPI-0.0.1.jar app.jar

CMD ["./wait-for-it/wait-for-it.sh", "rabbitmq:5672", "--", "java", "-jar", "app.jar"]

#ENTRYPOINT ["java", "-jar", "app.jar"]

