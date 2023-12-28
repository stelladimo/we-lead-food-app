package com.example.weleadfoodapp;

import com.example.weleadfoodapp.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeLeadFoodAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeLeadFoodAppApplication.class, args);

        var customer = new Customer();
        customer.setEmail("customer1@gmail.com");

        var customerViaBuilder = Customer.builder().lastname("Customer").firstname("Bob").Build();
    }

}
