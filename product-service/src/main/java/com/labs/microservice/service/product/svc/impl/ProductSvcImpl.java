package com.labs.microservice.service.product.svc.impl;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.labs.microservice.service.product.domain.ProductDomain;
import com.labs.microservice.service.product.repository.ProductRepository;
import com.labs.microservice.service.product.svc.ProductSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductSvcImpl implements ProductSvc {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public Collection<ProductDomain> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Collection<ProductDomain> findByType(ProductDomain productDomain) {
        List<ProductDomain> domainList = getProductDomains(productDomain);
        return domainList;
    }

    @Override
    public ProductDomain findOne(ProductDomain productDomain) {
        List<ProductDomain> domainList = getProductDomains(productDomain);
        return domainList.get(0);
    }

    @Override
    public ProductDomain findById(String s) {
        return productRepository.findOne(s);
    }

    @Override
    public ProductDomain save(ProductDomain searchProduct) {
        searchProduct.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        return productRepository.save(searchProduct);
    }

    @Override
    public Boolean delete(ProductDomain productDomain) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        if (productRepository.exists(id)) {
            productRepository.delete(id);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


    private List<ProductDomain> getProductDomains(ProductDomain productDomain) {
        Select select = QueryBuilder.select()
                .from("product");
        select.where(QueryBuilder.eq("sku", productDomain.getSku()));
        select.allowFiltering();
        List<ProductDomain> domainList = cassandraTemplate.select(select, ProductDomain.class);
        Objects.requireNonNull(domainList);
        return domainList;
    }
}
