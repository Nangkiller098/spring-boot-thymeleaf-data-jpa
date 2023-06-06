FROM openjdk:11
EXPOSE 8181
ADD target/web-spring-boot.war web-spring-boot.jar
ENTRYPOINT ["java","-jar","/web-spring-boot.jar"]