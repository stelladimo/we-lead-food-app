package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Category;

public interface CategoryService extends BaseService<Category, Long> {
    Category findByDescription(String description); // (1)
}
