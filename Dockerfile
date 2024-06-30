FROM openjdk:17-jdk

WORKDIR /app

COPY target/mouad-maqboul.jar /app/demo.jar
COPY src/main/resources/logback.xml  /app/logback.xml

RUN mkdir -p /app/logs

EXPOSE 8080

CMD ["java","-jar","demo.jar"]