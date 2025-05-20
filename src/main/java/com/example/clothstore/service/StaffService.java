package com.example.clothstore.service;

import com.example.clothstore.entity.Staff;

import java.util.List;

public interface StaffService {
    boolean isLoggedIn(String staffId, String staffPassword);
    Staff isLoggedIn(String staffId);
}
