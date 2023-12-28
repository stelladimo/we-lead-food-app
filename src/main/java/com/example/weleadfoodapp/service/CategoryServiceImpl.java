package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Category;
import com.example.weleadfoodapp.repository.BaseRepository;
import com.example.weleadfoodapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    protected BaseRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    public Category findByDescription(final String description) {
        return categoryRepository.findByDescription(description);
    }
}
