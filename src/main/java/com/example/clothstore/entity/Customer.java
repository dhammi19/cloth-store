package com.example.clothstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "customer")
public class Customer {
    @Id
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_birthday")
    private Date customerBirthday;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "customer_password")
    private String customerPassword;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_added_date")
    private Date customerAddedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Date getCustomerAddedDate() {
        return customerAddedDate;
    }

    public void setCustomerAddedDate(Date customerAddedDate) {
        this.customerAddedDate = customerAddedDate;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
