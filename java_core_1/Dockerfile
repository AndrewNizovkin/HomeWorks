FROM openjdk:17
COPY ./src/ ./src/
RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/Main.java
CMD ["java", "-classpath", "./out", "Main"] 
