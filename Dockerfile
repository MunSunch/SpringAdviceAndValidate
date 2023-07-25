FROM khipu/openjdk17-alpine
EXPOSE 8080
ADD target/SpringValidationAndAdvice-0.0.1-SNAPSHOT.jar /opt/app/app.jar
CMD ["java", "-jar", "/opt/app/app.jar"]