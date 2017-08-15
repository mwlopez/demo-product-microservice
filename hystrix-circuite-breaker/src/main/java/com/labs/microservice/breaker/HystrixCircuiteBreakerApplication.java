package com.labs.microservice.breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixCircuiteBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixCircuiteBreakerApplication.class, args);
	}
}
