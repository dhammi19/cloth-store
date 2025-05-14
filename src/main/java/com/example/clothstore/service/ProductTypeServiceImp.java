package com.example.clothstore.service;

import com.example.clothstore.entity.ProductType;
import com.example.clothstore.repository.ProductTypeRepository;
import com.example.clothstore.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ProductTypeServiceImp implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public boolean insertProductType(ProductType productType) {
        Date today = new Date();

        String productTypeId = IdGenerator.generateProductTypeId();

        productType.setProductTypeAddedDate(today);
        productType.setProductTypeId(productTypeId);

        if (productTypeRepository.existsById(productType.getProductTypeId())) {
            return false;
        }

        try {
            productTypeRepository.save(productType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProductTypeById(ProductType productType) {
        try {
            productTypeRepository.save(productType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteProductTypeById(String id) {
        try {
            productTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
