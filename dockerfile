FROM openjdk:11-jre-slim
WORKDIR /usr/src
ENV MYSQL_URI MYSQL_URI:jdbc:mysql://localhost:3306/mydemo
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD password
ADD ./target/user_service-0.0.1-SNAPSHOT.jar /usr/src/user_service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "user_service-0.0.1-SNAPSHOT.jar"]
