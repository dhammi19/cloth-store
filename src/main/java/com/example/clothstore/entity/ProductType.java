package com.example.clothstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.Set;

@Entity(name = "product_type")
public class ProductType {
    @Id
    private String productTypeId;

    @Column(name = "product_type_name")
    private String productTypeName;

    @Column(name = "product_type_added_date")
    private Date productTypeAddedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "productType") // tên của entity bên product class, không phải là tên cột trong database
    Set<Product> products;

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Date getProductTypeAddedDate() {
        return productTypeAddedDate;
    }

    public void setProductTypeAddedDate(Date productTypeAddedDate) {
        this.productTypeAddedDate = productTypeAddedDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
