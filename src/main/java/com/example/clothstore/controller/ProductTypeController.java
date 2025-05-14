package com.example.clothstore.controller;

import com.example.clothstore.entity.ProductType;
import com.example.clothstore.payload.ResponseData;
import com.example.clothstore.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("")
    public ResponseEntity<ResponseData> getProductType() {
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(true);
        responseData.setStatusCode(HttpStatus.OK.value());
        responseData.setData(productTypeService.getAll());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ResponseData> insertProductType(@RequestBody ProductType productType) {
        ResponseData responseData = new ResponseData();

        boolean result = productTypeService.insertProductType(productType);
        responseData.setSuccess(result);
        responseData.setData(productType);

        if (result) {
            responseData.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(responseData, HttpStatus.CREATED);
        } else {
            responseData.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseData.setData("Thêm loại sản phẩm thất bại.");
            return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
        }
    }
}
