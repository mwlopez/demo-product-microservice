package com.labs.microservice.client.product.service;

import com.labs.microservice.client.product.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate rest){
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "getProductFallback")
    public Product getProduct(String id){
        ResponseEntity<Product> exchange = restTemplate.exchange("http://localhost:9595/product/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
        }, id);
        return  exchange.getBody();
    }

    public Product getProductFallback(String id){
        return new Product(id, "N/A", "N/A");
    }
}
