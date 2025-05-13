package com.example.clothstore.service;

import com.example.clothstore.entity.Customer;
import com.example.clothstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerByIdAndPassword(String id, String password) {
        return customerRepository.findCustomerByCustomerIdAndCustomerPassword(id, password);
    }
}
