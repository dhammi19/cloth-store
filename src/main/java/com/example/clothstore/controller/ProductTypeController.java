package com.example.clothstore.controller;

import com.example.clothstore.entity.ProductType;
import com.example.clothstore.payload.response.DataResponse;
import com.example.clothstore.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-type")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("")
    public ResponseEntity<DataResponse> getProductType() {
        DataResponse dataResponse = new DataResponse();
        dataResponse.setSuccess(true);
        dataResponse.setStatusCode(HttpStatus.OK.value());
        dataResponse.setData(productTypeService.getAll());

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DataResponse> insertProductType(@RequestBody ProductType productType) {
        DataResponse dataResponse = new DataResponse();

        boolean result = productTypeService.insertProductType(productType);
        dataResponse.setSuccess(result);
        dataResponse.setData(productType);

        if (result) {
            dataResponse.setStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        } else {
            dataResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            dataResponse.setData("Thêm loại sản phẩm thất bại.");
            return new ResponseEntity<>(dataResponse, HttpStatus.OK);
        }
    }
}
