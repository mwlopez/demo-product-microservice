package com.labs.microservice.service.product.controller;

import com.labs.microservice.service.product.domain.ProductDomain;
import com.labs.microservice.service.product.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    @Autowired
    private ProductSvc productSvc;


    @RequestMapping("/product/{id}")
    public ProductDomain getProductById(@PathVariable() String id){
        ProductDomain productById = productSvc.findProductById(id);
        return productById;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductDomain saveProduct(@RequestBody ProductDomain productDomain){
        return productSvc.save(productDomain);
    }

}
