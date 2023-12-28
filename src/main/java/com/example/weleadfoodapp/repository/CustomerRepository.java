package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
    Customer findByEmail(String email);
}

