package com.example.clothstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ProductType {
    @Id
    private String productTypeId;

    @Column(name = "product_type_name")
    private String productTypeName;

    @Column(name = "product_type_added_date")
    private Date productTypeAddedDate;
}
