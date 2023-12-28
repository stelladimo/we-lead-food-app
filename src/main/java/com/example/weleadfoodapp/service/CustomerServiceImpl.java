package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Customer;
import com.example.weleadfoodapp.repository.BaseRepository;
import com.example.weleadfoodapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    protected BaseRepository<Customer, Long> getRepository() {
        return customerRepository;
    }

    @Override
    public Customer findByEmail(final String email) {
        return customerRepository.findByEmail(email);
    }
}
