package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySerial(final String serial);
}
