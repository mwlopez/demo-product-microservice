package com.labs.microservice.service.product.domain;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "product")
public class ProductDomain {

    @PrimaryKey
    private String id;

    private String sku;
    @Column(value = "productname")
    private String productName;

    private String imagepath;

    public ProductDomain() {
    }

    public ProductDomain(String id, String sku, String productName, String imagepath) {
        this.id = id;
        this.sku = sku;
        this.productName = productName;
        this.imagepath = imagepath;
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

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", productName='" + productName + '\'' +
                ", imagepath='" + imagepath + '\'' +
                '}';
    }
}
