FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY /review-service/.mvn/ .mvn
COPY /review-service/mvnw /review-service/pom.xml ./

RUN ./mvnw dependency:resolve

COPY ./review-service/src ./src
COPY ./reviews.csv .

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]