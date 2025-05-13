package com.example.clothstore.service;

import com.example.clothstore.repository.OrderProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductSizeServiceImp implements OrderProductSizeService {
    @Autowired
    private OrderProductSizeRepository orderProductSizeRepository;

}
