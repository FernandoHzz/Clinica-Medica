FROM openjdk
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/clinica.jar
ENTRYPOINT ["java", "-jar", "clinica.jar"]