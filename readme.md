Microservice Labs
=================
This is a proof of concept, which demonstrates [Microservice Architecture Pattern](http://martinfowler.com/microservices/) using Spring Boot, Spring Cloud, Angular 2, Cassandra, NodeJs and Docker.


### Version of components
For this poc were used the followings components an versions:


### Service port and name

Service | port
------- | ----
product-service         | 9595
product-client          | 9494
hystrix-circuit-breaker | 9191
eureka-server           | 8761

### Features
* Cache usage with hazelcast.
* Routing service using zuul
* Scaling service using docker-compose
* Registry with Eureka
* Data Repository with Cassandra



mvn clean compile package -DskipTests
docker-compose build
docker-compose up
docker run -it -d --name cassandra-node1 -p7000:7000 -p7001:7001 -p9042:9042 -p9160:9160 cassandra
