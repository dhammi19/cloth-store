package com.example.clothstore.repository;

import com.example.clothstore.entity.OrderProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductSizeRepository extends JpaRepository<OrderProductSize, String> {
}
