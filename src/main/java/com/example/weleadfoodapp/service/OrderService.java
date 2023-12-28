package com.example.weleadfoodapp.service;

import com.example.weleadfoodapp.model.Customer;
import com.example.weleadfoodapp.model.Order;
import com.example.weleadfoodapp.model.PaymentMethod;
import com.example.weleadfoodapp.model.Product;

public interface OrderService extends BaseService<Order, Long> {
    Order initiateOrder(Customer customer);

    void addItem(Order order, Product product, int quantity);

    void updateItem(Order order, Product product, int quantity);

    void removeItem(Order order, Product product);

    Order checkout(Order order, PaymentMethod paymentMethod);

}
//do mvn clean package