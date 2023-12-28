package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
}
