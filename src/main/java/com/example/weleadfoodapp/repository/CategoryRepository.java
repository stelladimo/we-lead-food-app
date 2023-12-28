package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
    Category findByDescription(String description);
}
