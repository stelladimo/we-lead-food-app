package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCategoryRepository extends JpaRepository<StoreCategory, Long> {
    StoreCategory findByDescription(String description);
}
