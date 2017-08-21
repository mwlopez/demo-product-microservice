package com.labs.microservice.client.product.domain;

import java.io.Serializable;

public class Product implements Serializable {
    String id;
    String sku;
    String productName;

    public Product() {
    }

    public Product(String id, String sku, String productName) {
        this.id = id;
        this.sku = sku;
        this.productName = productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
