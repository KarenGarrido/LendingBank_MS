FROM openjdk:17
ARG JAR_FILE=target/credit-simulator-service.jar
COPY ${JAR_FILE} credit-simulator-service.jar
ENTRYPOINT ["java","-jar","/credit-simulator-service.jar"]

ENV DATABASE_URL jdbc:mysql://localhost:3306/credit-simulator-schema
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD lenowo
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL8Dialect
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver


#docker build -t karengarrido/credit-simulator-service:latest .