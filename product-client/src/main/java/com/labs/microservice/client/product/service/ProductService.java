package com.labs.microservice.client.product.service;

import com.labs.microservice.client.product.config.ConfigProperty;
import com.labs.microservice.client.product.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final ProductServiceCache productServiceCache;

    @Autowired
    ConfigProperty configProperty;

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate rest, ProductServiceCache productServiceCache) {
        this.restTemplate = rest;
        this.productServiceCache = productServiceCache;
    }

    @HystrixCommand(fallbackMethod = "getProductFallback")
    public Product getProduct(String id) {
        if (configProperty.getCacheEnable()) {
            Product product = this.productServiceCache.getProduct(id);
            if (product == null) {
                product = getHttpProduct(id);
                productServiceCache.saveProduct(product);
            }
            return product;
        } else {
            return getHttpProduct(id);
        }
    }

    private Product getHttpProduct(String id) {
        Product product;
        ResponseEntity<Product> exchange = restTemplate.exchange("http://product-service:9595/product/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<Product>() {
                }, id);
        product = exchange.getBody();
        return product;
    }


    public Product getProductFallback(String id) {
        return new Product(id, "N/A", "N/A");
    }
}
