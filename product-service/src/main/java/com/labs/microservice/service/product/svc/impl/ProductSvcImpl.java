package com.labs.microservice.service.product.svc.impl;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.labs.microservice.service.product.domain.ProductDomain;
import com.labs.microservice.service.product.repository.ProductRepository;
import com.labs.microservice.service.product.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductSvcImpl implements ProductSvc {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public ProductDomain findProductById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public ProductDomain findProduct(ProductDomain searchProduct) {
        Select select = QueryBuilder.select()
                .from("product");
        select.where(QueryBuilder.eq("sku", searchProduct.getSku()));
        select.allowFiltering();
        List<ProductDomain> domainList = cassandraTemplate.select(select, ProductDomain.class);
        Objects.requireNonNull(domainList);
        return domainList.get(0);
    }

    @Override
    public ProductDomain save(ProductDomain searchProduct) {
        searchProduct.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return productRepository.save(searchProduct);
    }

    @Override
    public Boolean delete(String id) {
        if (productRepository.exists(id)) {
            productRepository.delete(id);
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}
