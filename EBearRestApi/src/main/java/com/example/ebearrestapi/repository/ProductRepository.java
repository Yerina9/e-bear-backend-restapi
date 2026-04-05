package com.example.ebearrestapi.repository;

import com.example.ebearrestapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
