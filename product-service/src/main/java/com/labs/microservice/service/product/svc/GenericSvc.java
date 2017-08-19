package com.labs.microservice.service.product.svc;

import java.util.Collection;

/**
 * Date: 8/16/17
 * Created by marcelolopez
 * Project: demo-product-microservice
 */
public interface GenericSvc<T, L extends String> {
    Collection<T> findAll();
    Collection<T> findByType(T t);
    T findOne(T t);
    T findById(L l);
    T save(T t);
    Boolean delete(T t);
    Boolean delete(L l);
}
