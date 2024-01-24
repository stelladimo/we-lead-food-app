package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.mapper.BaseMapper;
import com.example.weleadfoodapp.mapper.CustomerMapper;
import com.example.weleadfoodapp.model.Customer;
import com.example.weleadfoodapp.service.BaseService;
import com.example.weleadfoodapp.service.CustomerService;
import com.example.weleadfoodapp.transfer.ApiResponse;
import com.example.weleadfoodapp.transfer.resource.CustomerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController extends BaseController<Customer, CustomerResource> {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    protected BaseService<Customer, Long> getBaseService() {
        return customerService;
    }

    @Override
    protected BaseMapper<Customer, CustomerResource> getMapper() {
        return customerMapper;
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<CustomerResource>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(ApiResponse.<CustomerResource>builder()
                .data(customerMapper.toResource(customerService.findByEmail(email)))
                .build());
    }
}