FROM openjdk:8-jdk-alpine

VOLUME /tmp

WORKDIR /app

# ARG JAR_FILE

COPY target/bookstore-payment-service-0.0.1-SNAPSHOT.jar /app/payment-service.jar

#Using Dokerize to check whether db is up, if it is then start this service.
# COPY dockerize dockerize

# CMD ./dockerize -wait tcp://bookstore-mysql-db:3306 -timeout 15m java -Djava.security.egd=file:/dev/./urandom -jar /payment-service.jar --spring.config.location=/config/application.properties

CMD java -Djava.security.egd=file:/dev/./urandom -jar /app/payment-service.jar --spring.config.location=/app/src/main/resources/application.yml
