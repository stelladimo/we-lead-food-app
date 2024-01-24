package com.example.weleadfoodapp.controller;

import com.example.weleadfoodapp.mapper.BaseMapper;
import com.example.weleadfoodapp.mapper.OrderMapper;
import com.example.weleadfoodapp.model.Order;
import com.example.weleadfoodapp.service.BaseService;
import com.example.weleadfoodapp.service.OrderService;
import com.example.weleadfoodapp.transfer.resource.OrderResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController extends BaseController<Order, OrderResource> {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    protected BaseService<Order, Long> getBaseService() {
        return orderService;
    }

    @Override
    protected BaseMapper<Order, OrderResource> getMapper() {
        return orderMapper;
    }
}
