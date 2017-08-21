package com.labs.microservice.service.product.svc;


import com.labs.microservice.service.product.domain.ProductDomain;

import java.util.Collection;

public interface ProductSvc{
    Collection<ProductDomain> findAll();
    Collection<ProductDomain> findByType(ProductDomain productDomain);
    ProductDomain findOne(ProductDomain productDomain);
    ProductDomain findById(String s);
    ProductDomain save(ProductDomain searchProduct);
    Boolean delete(ProductDomain productDomain);
    Boolean delete(String id);
}
