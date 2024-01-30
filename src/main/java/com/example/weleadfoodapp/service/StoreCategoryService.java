package com.example.weleadfoodapp.service;


import com.example.weleadfoodapp.model.StoreCategory;

public interface StoreCategoryService extends BaseService<StoreCategory, Long> {
    StoreCategory findByDescription(String description); // (1)
}
