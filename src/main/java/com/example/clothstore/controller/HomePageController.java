package com.example.clothstore.controller;

import com.example.clothstore.entity.Product;
import com.example.clothstore.entity.ProductSize;
import com.example.clothstore.payload.ResponseData;
import com.example.clothstore.service.ProductService;
import com.example.clothstore.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-page")
public class HomePageController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductSizeService productSizeService;

    @GetMapping("/products")
    public Object showProducts() {
        List<Product> productList = productService.getProducts();

        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        responseData.setSuccess(productList != null);
        responseData.setData(productList);

        return responseData;
    }

    @PostMapping("/product-sizes")
    public Object showProductSizes(
            @RequestParam("product-id") String productId) {
        List<ProductSize> productSizeList = productSizeService.getProductSizesByProductId(productId);

        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        responseData.setSuccess(productSizeService != null);
        responseData.setData(productSizeList);

        return responseData;
    }
}
