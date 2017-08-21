package com.labs.microservice.client.product;

import com.labs.microservice.client.product.service.ProductServiceCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProductClientApplication {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public ProductServiceCache serviceCache(){
		return new ProductServiceCache();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductClientApplication.class, args);
	}
}
