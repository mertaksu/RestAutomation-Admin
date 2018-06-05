FROM maven:3-alpine

COPY pom.xml RestAutomationAdmin/

COPY /* RestAutomationAdmin/

WORKDIR RestAutomationAdmin/

RUN mvn clean install

EXPOSE 8090

ENTRYPOINT [ "java", "-jar", "/RestAutomationAdmin/RestAutomationAdmin-rest-services/target/RestAutomationAdmin-rest-services-1.0.0-MASTER.jar"]