FROM debian:unstable-slim
RUN apt update && apt install openjdk-20-jdk -y
ARG JAR_FILE= target/test-task-0.0.1-SNAPSHOT.jar
WORKDIR /home/andrew/GeekBrains/HomeWorks/javacode_test_task/test-task
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
