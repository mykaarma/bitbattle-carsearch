FROM openjdk:8-alpine
ADD bitbattle-carsearch*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
