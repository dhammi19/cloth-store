package com.example.clothstore.service;

import com.example.clothstore.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImp implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;
}
