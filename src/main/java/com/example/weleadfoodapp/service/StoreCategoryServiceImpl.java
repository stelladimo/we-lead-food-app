package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.StoreCategory;
import com.example.weleadfoodapp.repository.StoreCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCategoryServiceImpl extends BaseServiceImpl<StoreCategory> implements StoreCategoryService {
    private final StoreCategoryRepository storecategoryRepository;

    @Override
    protected JpaRepository<StoreCategory, Long> getRepository() {
        return storecategoryRepository;
    }

    @Override
    public StoreCategory findByDescription(final String description) {
        return storecategoryRepository.findByDescription(description);
    }
}
