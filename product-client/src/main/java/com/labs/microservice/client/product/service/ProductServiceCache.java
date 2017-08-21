package com.labs.microservice.client.product.service;

import com.google.gson.Gson;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.labs.microservice.client.product.domain.Product;

import java.util.concurrent.ConcurrentMap;

public class ProductServiceCache {
    ConcurrentMap<String, String> map;

    public  ProductServiceCache(){
        Config config = new Config();
        HazelcastInstance h = Hazelcast.newHazelcastInstance(config);
        ConcurrentMap<String, String> map = h.getMap("product-cache");
        this.map = map;
    }

    public Product getProduct(String id){
        String pString = this.map.get(id);
        Product product = new Gson().fromJson(pString, Product.class);
        return product;
    }

    public Boolean saveProduct(Product product){
        String sProduct = new Gson().toJson(product);
        String put = this.map.put(product.getId(), sProduct);
        return (put != null);
    }

}
