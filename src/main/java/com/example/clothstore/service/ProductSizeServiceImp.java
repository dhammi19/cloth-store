package com.example.clothstore.service;

import com.example.clothstore.entity.ProductSize;
import com.example.clothstore.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeServiceImp implements ProductSizeService {
    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Override
    public List<ProductSize> getProductSizesByProductId(String productId) {
        return productSizeRepository.findAllByProduct_ProductId(productId);
    }
}
