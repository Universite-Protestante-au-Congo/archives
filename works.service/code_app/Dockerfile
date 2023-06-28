FROM maven:3.8.4-jdk-8

WORKDIR /code_app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run