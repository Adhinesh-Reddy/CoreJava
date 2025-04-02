package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItems;
import com.example.demo.repo.OrderItemRepo;
import com.example.demo.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    public OrderItems addOrderItem(OrderItemDto orderItemDto) {
        OrderItems orderItem = new OrderItems();

        BeanUtils.copyProperties(orderItemDto, orderItem); // Assuming you have a utility to copy properties from DTO to entity

        return orderItemRepo.save(orderItem); // Save the entity to the database and return it, assuming you have an orderRepo to handle DB operations
    
    }

    @Override
    public OrderItems updateOrderItem(Long orderItemId, OrderItemDto orderItemDto) {
        OrderItems orderItem = orderItemRepo.findById(orderItemId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderItemId)); // Find existing order

        BeanUtils.copyProperties(orderItemDto, orderItem); // Copy properties from DTO to existing entity

        return orderItemRepo.save(orderItem); // Save the updated entity to the database and return it
    }

    @Override
    public void softDeleteOrderItem(Long orderItemId) {
        OrderItems orderItem = orderItemRepo.findById(orderItemId)
        .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderItemId)); // Find existing order

        orderItem.setDeleted(true); // Mark as deleted (assuming you have a 'deleted' field in your entity)
        orderItemRepo.save(orderItem); // Save the changes to the database
    }

    
    
}
