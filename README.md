# Redis cache with Spring-Boot 

This is a sample spring-boot project to demonstrate redis cache with spring-boot.

Blog post: http://www.rajith.me/2020/02/using-redis-with-spring-boot.html

## Requirements
* Java 8
* Apache Maven 3.5.0 or higher

## How to Run

- Clone the project
- Configure Redis password in application.yml
- Build the project  
```
mvn clean install
```
- Run the application
```
java -jar target/redis-0.0.1-SNAPSHOT.jar
```
- Make sure your redis-server is up and running
- Use the postman collection located in /src/main/resources directory to test the application.

### Reference Documentation
For further reference, please consider the following sections:

(Redis-Client) https://lettuce.io/