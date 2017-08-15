package com.labs.microservice.client.product.controller;

import com.labs.microservice.client.product.domain.Product;
import com.labs.microservice.client.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable String id){
       return productService.getProduct(id);
    }

}
