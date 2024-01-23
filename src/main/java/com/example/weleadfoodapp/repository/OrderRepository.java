package com.example.weleadfoodapp.repository;

import com.example.weleadfoodapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o join fetch o.customer where o.id = :id")
    Optional<Order> findWithCustomer(Long id);

    @Query("""
            select o from Order o join fetch o.customer join fetch o.orderItems oi join fetch oi.product where o.id =:id
            """)
    Optional<Order> findWithAllAssociations(Long id);
}
