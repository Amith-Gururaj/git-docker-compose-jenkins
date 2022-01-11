FROM openjdk:8
EXPOSE 8085
ADD target/backend-image.jar backend-image.jar
ENTRYPOINT ["java","-jar","/backend-image.jar"]