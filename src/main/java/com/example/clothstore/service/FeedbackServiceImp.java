package com.example.clothstore.service;

import com.example.clothstore.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImp implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
}
