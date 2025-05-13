package com.example.clothstore.repository;

import com.example.clothstore.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, String> {
    List<ProductSize> findAllByProduct_ProductId(String productId);
}
