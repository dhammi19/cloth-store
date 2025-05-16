package com.example.clothstore.controller;


import com.example.clothstore.entity.Customer;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    CustomerService customerService;

    @PostMapping("")
    public Object login(
            @RequestParam("id") String id,
            @RequestParam("password") String password) {
        List<Customer> customerList = customerService.getCustomerByIdAndPassword(id, password);

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatusCode(200);
        dataResponse.setSuccess(customerList != null);
        dataResponse.setData(customerList);

        return dataResponse;
    }
}
