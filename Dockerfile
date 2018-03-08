FROM maven:3-alpine

COPY pom.xml RestAutomationAdmin/

COPY RestAutomationAdmin-commons/src/ RestAutomationAdmin/RestAutomationAdmin-commons/src/
COPY RestAutomationAdmin-da-parent/src/ RestAutomationAdmin/RestAutomationAdmin-da-parent/src/
COPY RestAutomationAdmin-dto/src/ RestAutomationAdmin/RestAutomationAdmin-dto/src/
COPY RestAutomationAdmin-resources/src/ RestAutomationAdmin/RestAutomationAdmin-resources/src/
COPY RestAutomationAdmin-rest-services/src/ RestAutomationAdmin/RestAutomationAdmin-rest-services/src/
COPY RestAutomationAdmin-services/src/ RestAutomationAdmin/RestAutomationAdmin-services/src/

WORKDIR RestAutomationAdmin/

RUN mvn clean install

EXPOSE 8090

ENTRYPOINT [ "java", "-jar", "/RestAutomationAdmin/RestAutomationAdmin-rest-services/target/RestAutomationAdmin-rest-services-1.0.0-MASTER.jar"]