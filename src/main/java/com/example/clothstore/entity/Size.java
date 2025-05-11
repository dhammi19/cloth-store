package com.example.clothstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "size")
public class Size {
    @Id
    private String sizeId;

    @Column(name = "size_name")
    private String sizeName;

    @Column(name = "size_added_date")
    private String sizeAddedDate;
}
