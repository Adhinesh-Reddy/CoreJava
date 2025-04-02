package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OrderItems;

public interface OrderItemRepo extends JpaRepository<OrderItems, Long>{
    
}
