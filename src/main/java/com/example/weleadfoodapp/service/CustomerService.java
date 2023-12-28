package com.example.weleadfoodapp.service;


import com.example.weleadfoodapp.model.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
    Customer findByEmail(String email);
}
