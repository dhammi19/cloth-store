package com.example.clothstore.service;

import com.example.clothstore.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;
}
