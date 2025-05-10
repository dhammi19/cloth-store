package com.example.clothstore.controller;


import com.example.clothstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    CustomerService customerService;

    @PostMapping("")
    public Object login() {
        return customerService.getCustomers();
    }
}
