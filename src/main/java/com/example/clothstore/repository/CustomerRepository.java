package com.example.clothstore.repository;

import com.example.clothstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findCustomerByCustomerIdAndCustomerPassword(String customerId, String customerPassword);
}
