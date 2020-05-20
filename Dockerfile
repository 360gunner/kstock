FROM openjdk:8-jdk-alpine
EXPOSE 9002
ADD target/Stock-0.0.1-SNAPSHOT.jar /Stock-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Stock-0.0.1-SNAPSHOT.jar"]