package com.example.clothstore.entity;

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

    @OneToMany(mappedBy = "productType") // tên của entity bên product class, không phải là tên cột trong database
    Set<Product> products;
}
