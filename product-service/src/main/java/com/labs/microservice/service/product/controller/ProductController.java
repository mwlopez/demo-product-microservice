package com.labs.microservice.service.product.controller;

import com.labs.microservice.service.product.domain.ProductDomain;
import com.labs.microservice.service.product.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    @Autowired
    private ProductSvc productSvc;


    @RequestMapping("/product/{id}")
    public ProductDomain getProductById(@PathVariable() String id){
        return productSvc.findProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductDomain saveProduct(@RequestBody ProductDomain productDomain){
        return productSvc.save(productDomain);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public Boolean deleteProduct(@PathVariable() String id){
        return productSvc.delete(id);
    }

}
