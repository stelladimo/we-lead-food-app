package com.example.weleadfoodapp;

import com.example.weleadfoodapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeLeadFoodAppApplication {
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(WeLeadFoodAppApplication.class, args);

        var customer = new Customer();
        customer.setEmail("customer1@gmail.com");

        var customerViaBuilder = Customer.builder().lastname("Customer").firstname("Bob").build();
    }

}
