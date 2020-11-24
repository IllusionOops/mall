FROM openjdk:8-jdk-alpine
LABEL description="描述"
WORKDIR app
ADD api-impl-commodity-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 9010
CMD java -jar /app/app.jar --Dapollo.configService=http://172.20.1.50:8080 --spring.profiles.active=prod
