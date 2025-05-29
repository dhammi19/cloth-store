package com.example.clothstore.controller;

import com.example.clothstore.entity.Product;
import com.example.clothstore.entity.ProductSize;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.ProductService;
import com.example.clothstore.service.ProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/home-page")
public class HomePageController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductSizeService productSizeService;

    @GetMapping("/products")
    public Object showProducts() {
        List<Product> productList = productService.getProducts();

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatusCode(200);
        dataResponse.setSuccess(productList != null);
        dataResponse.setData(productList);

        return dataResponse;
    }

    @PostMapping("/product-sizes")
    public Object showProductSizes(
            @RequestParam("product-id") String productId) {
        List<ProductSize> productSizeList = productSizeService.getProductSizesByProductId(productId);

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatusCode(200);
        dataResponse.setSuccess(productSizeService != null);
        dataResponse.setData(productSizeList);

        return dataResponse;
    }
}
