package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(final String name);
}
