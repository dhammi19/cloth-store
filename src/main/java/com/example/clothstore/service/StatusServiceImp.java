package com.example.clothstore.service;

import com.example.clothstore.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImp implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
}
