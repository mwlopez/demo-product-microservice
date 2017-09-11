package com.labs.microservice.client.product.service;

import com.google.gson.Gson;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.labs.microservice.client.product.domain.Product;

import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public class ProductServiceCache {
    private  final Logger logger = Logger.getLogger(ProductServiceCache.class.getName());


    ConcurrentMap<String, String> map;

    public ProductServiceCache(String ip){
        ClientConfig clientConfig = new ClientConfig();
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.addAddress(ip);

        HazelcastInstance h = HazelcastClient.newHazelcastClient(clientConfig);
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
