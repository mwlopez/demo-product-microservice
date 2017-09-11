Microservice Labs
=================
This is a proof of concept, which demonstrates [Microservice Architecture Pattern](http://martinfowler.com/microservices/) using Spring Boot, Spring Cloud, Angular 2, Cassandra, NodeJs and Docker.

### Prerequisites
[Git](https://help.github.com/articles/set-up-git/) and the [OpenJDK8](http://openjdk.java.net/projects/jdk8/) build.

Be sure that your JAVA_HOME environment variable points to the jdk folder extracted from the JDK download, and run cassandra container.


### Installation and getting started

Install, compile and package code using the following line

```
mvn clean compile package -DskipTests
```

Once the code are compiled, it can create a docker container using the following instruction

```
docker-compose build
docker-compose up
```

Finally run init.sql script in cassandra container.



### Service port and name

Service | port
------- | ----
product-service         | 9595
product-client          | 9494
hystrix-circuit-breaker | 9191
eureka-server           | 8761
hazelcast-server        | 5701
cassandra-server        | 9042

### Features
* Cache usage with hazelcast.
* Routing service using zuul
* Scaling service using docker-compose
* Registry with Eureka
* Data Repository with Cassandra