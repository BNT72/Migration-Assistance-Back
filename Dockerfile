FROM maven:3.8.6-amazoncorretto-17

COPY ./ ./

EXPOSE 8080

RUN mvn clean package

CMD ["java", "-jar","target/back-0.0.1-SNAPSHOT.jar"]

