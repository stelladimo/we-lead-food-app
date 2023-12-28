package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    Product findBySerial(final String serial);
}
