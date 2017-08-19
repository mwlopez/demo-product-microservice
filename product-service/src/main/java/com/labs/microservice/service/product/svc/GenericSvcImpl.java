package com.labs.microservice.service.product.svc;

import java.util.Collection;

/**
 * Date: 8/16/17
 * Created by marcelolopez
 * Project: demo-product-microservice
 */
public class GenericSvcImpl<K, L extends String> implements GenericSvc<K, String>{
    @Override
    public Collection<K> findAll() {
        return null;
    }

    @Override
    public Collection<K> findByType(K k) {
        return null;
    }

    @Override
    public K findOne(K k) {
        return null;
    }

    @Override
    public K findById(String s) {
        return null;
    }

    @Override
    public K save(K k) {
        return null;
    }

    @Override
    public Boolean delete(K k) {
        return null;
    }

    @Override
    public Boolean delete(String s) {
        return null;
    }
}
