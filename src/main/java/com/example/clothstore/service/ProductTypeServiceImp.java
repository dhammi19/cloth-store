package com.example.clothstore.service;

import com.example.clothstore.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImp implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
}
