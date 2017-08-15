Microservice Labs
=================



product-service         : 9595
product-client          : 9494
hystrix-circuit-breaker : 9191
eureka-server           : 8761

docker run -it -d --name cassandra-node1 -p7000:7000 -p7001:7001 -p9042:9042 -p9160:9160 cassandra
