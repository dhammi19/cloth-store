package com.example.clothstore.service;

import com.example.clothstore.entity.Staff;
import com.example.clothstore.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public boolean isLoggedIn(String staffId, String staffPassword) {
        List<Staff> staffs = staffRepository.findByStaffIdAndStaffPassword(staffId, staffPassword);

        if (staffs.size() != 0) {
            // System.out.println("Kiểm tra size:"+staffs.size());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Staff isLoggedIn(String staffId) {
        List<Staff> staffs = staffRepository.findByStaffId(staffId);

        if (staffs.size() != 0) {
            return staffs.get(0);
        } else {
            return null;
        }
    }
}
