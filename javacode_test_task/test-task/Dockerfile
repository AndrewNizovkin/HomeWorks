FROM ubuntu:jammy
RUN apt update && apt install openjdk-17-jdk -y
WORKDIR /home/andrew/GeekBrains/HomeWorks/javacode_test_task/test-task
COPY target/test-task-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "test-task-0.0.1-SNAPSHOT.jar"]
