#FROM openjdk:11
#WORKDIR /app
#ADD target/account-0.0.1-SNAPSHOT.jar  account-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java" , "-jar" , "account-0.0.1-SNAPSHOT.jar"]

FROM openjdk:11
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean install -U
ENTRYPOINT ["./mvnw" , "spring-boot:run"]
