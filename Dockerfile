FROM openjdk:17-jdk-alpine
COPY target/leboncoin-interview-0.0.1-SNAPSHOT.jar leboncoin-interview-0.0.1.jar
ENTRYPOINT ["java","-jar","/leboncoin-interview-0.0.1.jar"]