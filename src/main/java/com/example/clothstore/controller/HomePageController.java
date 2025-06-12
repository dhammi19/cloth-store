package com.example.clothstore.controller;

import com.example.clothstore.entity.Product;
import com.example.clothstore.entity.ProductSize;
import com.example.clothstore.entity.ProductType;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.ProductService;
import com.example.clothstore.service.ProductSizeService;
import com.example.clothstore.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/home-page")
public class HomePageController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductSizeService productSizeService;

    @GetMapping("/product-type")
    public ResponseEntity<DataResponse> showProductType() {
        List<ProductType> productTypeList = productTypeService.getAll();

        DataResponse dataResponse = new DataResponse();
        dataResponse.setSuccess(true);
        dataResponse.setStatusCode(HttpStatus.OK.value());
        dataResponse.setData(productTypeList);

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<DataResponse> showProducts() {
        List<Product> productList = productService.getProducts();

        DataResponse dataResponse = new DataResponse();
        dataResponse.setStatusCode(200);
        dataResponse.setSuccess(productList != null);
        dataResponse.setData(productList);

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
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
