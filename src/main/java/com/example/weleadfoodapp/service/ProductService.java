package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Product;

public interface ProductService extends BaseService<Product, Long> {
    Product findBySerial(String serial);

    Product create(Product product, Long categoryId);
}
