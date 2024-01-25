package com.example.weleadfoodapp.bootstrap;

import com.example.weleadfoodapp.base.BaseComponent;
import com.example.weleadfoodapp.model.Customer;
import com.example.weleadfoodapp.model.Order;
import com.example.weleadfoodapp.model.PaymentMethod;
import com.example.weleadfoodapp.service.CustomerService;
import com.example.weleadfoodapp.service.OrderService;
import com.example.weleadfoodapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("generate-orders")
@RequiredArgsConstructor
public class OrderCreator extends BaseComponent implements CommandLineRunner {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ProductService productService;

    @Override
    public void run(String... args) {
        // Get all customers
        customerService.findAll().forEach(c -> logger.info("{}", c));

        // We don't mind if a "find" method returns a null
        logger.info("Does customer exist? {}.", (customerService.findByEmail("customer1@test.gr") != null));
        logger.info("Does customer exist? {}.", (customerService.findByEmail("customer2@test.gr") != null));

        // Load customer and create an order by adding/updating/removing content before checking it out
        Customer firstCustomer = customerService.findByEmail("customer1@test.gr");
        Order firstOrder = orderService.initiateOrder(firstCustomer);

        // Add item(s) both existing and non-existing
        orderService.addItem(firstOrder, productService.findBySerial("prod-0001"), 2);
        orderService.addItem(firstOrder, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(firstOrder, productService.findBySerial("prod-0004"), 1);
        // Add a non-existing product
        orderService.addItem(firstOrder, productService.findBySerial("prod-0008"), 1);
        // Update item(s)
        orderService.addItem(firstOrder, productService.findBySerial("prod-0001"), 1);
        orderService.updateItem(firstOrder, productService.findBySerial("prod-0004"), 2);
        // Remove item(s)
        orderService.removeItem(firstOrder, productService.findBySerial("prod-0001"));
        // Add some more item(s)
        orderService.addItem(firstOrder, productService.findBySerial("prod-0001"), 2);
        // Checkout order
        orderService.checkout(firstOrder, PaymentMethod.CREDIT_CARD);

        // Second customer and order
        Customer secondCustomer = customerService.get(2L);
        Order secondOrder = orderService.initiateOrder(secondCustomer);
        // Add item(s) to second order
        orderService.addItem(secondOrder, productService.findBySerial("prod-0002"), 1);
        orderService.addItem(secondOrder, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(secondOrder, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(secondOrder, productService.findBySerial("prod-0001"), 1);
        // Checkout 2nd order
        orderService.checkout(secondOrder, PaymentMethod.CASH);

        // Third customer and order
        Customer thirdCustomer = customerService.findByEmail("malcolm.paker@gmailx.com");
        Order thirdOrder = orderService.initiateOrder(thirdCustomer);
        orderService.addItem(thirdOrder, productService.findBySerial("prod-0001"), 3);
        orderService.addItem(thirdOrder, productService.findBySerial("prod-0002"), 2);
        orderService.addItem(thirdOrder, productService.findBySerial("prod-0003"), 1);
        // Checkout 3rd order
        orderService.checkout(thirdOrder, PaymentMethod.CREDIT_CARD);

        // Fourth customer and order
        Customer fourthCustomer = customerService.findByEmail("terry.jones@gmailx.com");
        Order fourthOrder = orderService.initiateOrder(fourthCustomer);
        orderService.addItem(fourthOrder, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(fourthOrder, productService.findBySerial("prod-0001"), 2);
        orderService.addItem(fourthOrder, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(fourthOrder, productService.findBySerial("prod-0003"), 1);
        orderService.addItem(fourthOrder, productService.findBySerial("prod-0004"), 1);
        // Checkout 4th order
        orderService.checkout(fourthOrder, PaymentMethod.CREDIT_CARD);

        // **** SOME EXTRA ORDERS FOR SHOWCASING WITHIN THE APPLICATION **** //
        // customer and order
        Customer c5 = customerService.get(5L);
        Order o5 = orderService.initiateOrder(c5);
        // Add item(s) to order
        orderService.addItem(o5, productService.findBySerial("prod-0002"), 4);
        orderService.addItem(o5, productService.findBySerial("prod-0001"), 2);
        orderService.addItem(o5, productService.findBySerial("prod-0001"), 1);
        // Checkout order
        orderService.checkout(o5, PaymentMethod.CASH);

        // customer and order
        Customer c6 = customerService.get(6L);
        Order o6 = orderService.initiateOrder(c6);
        // Add item(s) to order
        orderService.addItem(o6, productService.findBySerial("prod-0001"), 2);
        // Checkout order
        orderService.checkout(o6, PaymentMethod.CREDIT_CARD);

        // customer and order
        Customer c7 = customerService.get(7L);
        Order o7 = orderService.initiateOrder(c7);
        // Add item(s) to order
        orderService.addItem(o7, productService.findBySerial("prod-0002"), 4);
        orderService.addItem(o7, productService.findBySerial("prod-0001"), 1);
        // Checkout order
        orderService.checkout(o7, PaymentMethod.CREDIT_CARD);

        // customer and order
        Customer c8 = customerService.get(8L);
        Order o8 = orderService.initiateOrder(c8);
        // Add item(s) to order
        orderService.addItem(o8, productService.findBySerial("prod-0002"), 1);
        orderService.addItem(o8, productService.findBySerial("prod-0001"), 1);
        orderService.addItem(o8, productService.findBySerial("prod-0001"), 1);
        // Checkout order
        orderService.checkout(o8, PaymentMethod.CASH);

        // customer and order
        Customer c9 = customerService.get(9L);
        Order o9 = orderService.initiateOrder(c9);
        // Add item(s) to order
        orderService.addItem(o9, productService.findBySerial("prod-0001"), 1);
        // Checkout order
        orderService.checkout(o9, PaymentMethod.CASH);

        // customer and order
        Customer c10 = customerService.get(10L);
        Order o10 = orderService.initiateOrder(c10);
        // Add item(s) to order
        orderService.addItem(o10, productService.findBySerial("prod-0001"), 3);
        // Checkout order
        orderService.checkout(o10, PaymentMethod.CREDIT_CARD);
    }
}
