package com.example.clothstore.service;

import com.example.clothstore.entity.ProductSize;

import java.util.List;

public interface ProductSizeService {
    List<ProductSize> getProductSizesByProductId(String productId);
}
