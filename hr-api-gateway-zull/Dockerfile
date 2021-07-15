#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -DskipTests
#RUN mvn -f /home/app/pom.xml clean package  -DskipTests

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/hr-api-gateway-zull-0.0.1-SNAPSHOT.jar /home/app/hr-api-gateway-zull.jar
EXPOSE 8765
ENTRYPOINT ["java","-jar","/home/app/hr-api-gateway-zull.jar"]
