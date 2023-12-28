package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Category;
import com.example.weleadfoodapp.model.Product;
import com.example.weleadfoodapp.repository.BaseRepository;
import com.example.weleadfoodapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    private final ProductRepository productRepository;

    @Override
    protected BaseRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Product findBySerial(final String serial) {
        return productRepository.findBySerial(serial);
    }

    @Override
    public Product create(final Product product, final Category category) {
        product.setCategory(category);
        return productRepository.create(product);
    }
}