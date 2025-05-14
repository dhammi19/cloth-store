package com.example.clothstore.service;

import com.example.clothstore.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> getAll();
    boolean insertProductType(ProductType productType);
    boolean updateProductTypeById(ProductType productType);
    boolean deleteProductTypeById(String id);
}
