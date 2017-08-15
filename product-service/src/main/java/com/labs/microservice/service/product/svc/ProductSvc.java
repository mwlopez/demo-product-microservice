package com.labs.microservice.service.product.svc;

import com.labs.microservice.service.product.domain.ProductDomain;


public interface ProductSvc {
    ProductDomain findProductById(String id);
    ProductDomain findProduct(ProductDomain searchProduct);
    ProductDomain save(ProductDomain searchProduct);
    Boolean delete(String id);
}
