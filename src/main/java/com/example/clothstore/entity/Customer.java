package com.example.clothstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "customer")
public class Customer {
    @Id
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_birthday")
    private String customerBirthday;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_password")
    private String customerPassword;

    @Column(name = "customer_added_date")
    private String customerAddedDate;
}
