package com.labs.microservice.service.product.repository;

import com.labs.microservice.service.product.domain.ProductDomain;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<ProductDomain, String>{

}
