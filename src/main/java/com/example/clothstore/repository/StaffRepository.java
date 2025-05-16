package com.example.clothstore.repository;

import com.example.clothstore.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    List<Staff> findByStaffIdAndStaffPassword(String staffId, String staffPassword);
} 
