package com.example.clothstore.service;

import com.example.clothstore.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerByIdAndPassword(String id, String password);
}
