package com.example.clothstore.controller;

import com.example.clothstore.entity.Product;
import com.example.clothstore.payload.ResponseData;
import com.example.clothstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home-page")
public class HomePageController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public Object homePage() {
        List<Product> productList = productService.getProducts();

        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        responseData.setSuccess(productList != null);
        responseData.setData(productList);

        return responseData;
    }
}
