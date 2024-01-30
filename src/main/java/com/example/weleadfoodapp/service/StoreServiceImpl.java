package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Store;
import com.example.weleadfoodapp.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
    private final StoreRepository storeRepository; // Replace with your actual StoreRepository class

    @Override
    protected JpaRepository<Store, Long> getRepository() {
        return storeRepository; // Replace with your actual StoreRepository class
    }

    @Override
    public Store findByName(final String name) {
        return storeRepository.findByName(name);
    }

    @Override
    public Store create(final Store store) {
        return storeRepository.save(store);
    }
}
