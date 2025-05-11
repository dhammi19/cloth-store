package com.example.clothstore.entity;

import jakarta.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_added_date")
    private String productAddedDate;

    @ManyToOne
    @JoinColumn(name = "product_type_id") // tên của cột trong database, không phải tên entity
    ProductType productType; // đây là tên entity đã được ProductType class mapping đến
}
