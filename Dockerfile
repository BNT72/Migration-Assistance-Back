FROM maven:3.8.6-eclipse-temurin-17-alpine

RUN apk add git && git clone https://github.com/BNT72/Migration-Assistance-Back.git && cd Migration-Assistance-Back &&  mvn clean package

WORKDIR ./Migration-Assistance-Back

EXPOSE 8080

CMD ["java", "-jar","target/back-0.0.1-SNAPSHOT.jar"]

