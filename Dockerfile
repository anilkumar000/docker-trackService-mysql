From openjdk:11
WorkDIR /usr/src
ENV MYSQL_DATABASE=trackService

ADD ./target/track-service-0.0.1-SNAPSHOT.jar /usr/src/track-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","track-service-0.0.1-SNAPSHOT.jar"]