package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Store;

public interface StoreService extends BaseService<Store, Long> {
    Store findByName(String name);

    Store create(Store store);
}
