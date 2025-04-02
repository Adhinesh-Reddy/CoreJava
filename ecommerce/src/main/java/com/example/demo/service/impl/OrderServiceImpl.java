package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItems;
import com.example.demo.repo.OrderItemRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo; // Assuming you have an OrderRepo to handle database operations
    @Autowired
    private OrderItemRepo orderItemRepo; // Assuming you have an OrderRepo to handle database operations

    @Override
    public Order addOrder(OrderDto orderDto) {
        Order order = new Order();

        BeanUtils.copyProperties(orderDto, order); // Assuming you have a utility to copy properties from DTO to entity

        return orderRepo.save(order); // Save the entity to the database and return it, assuming you have an orderRepo to handle DB operations
    }

    @Override
    public Order updateOrder(Long orderId, OrderDto orderDto) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId)); // Find existing order

        BeanUtils.copyProperties(orderDto, order); // Copy properties from DTO to existing entity

        Set<OrderItems> orderItems = new HashSet<>();

        for(Long orderItemId: orderDto.getOrderItemIds()){
            OrderItems orderItem = orderItemRepo.findById(orderItemId).orElseThrow(()->new RuntimeException("Order Item not found with id: "+ orderItemId));
            orderItems.add(orderItem);
        }
        
        order.setOrderItems(orderItems);

        return orderRepo.save(order); // Save the updated entity to the database and return it
    }

    @Override
    public void softDeleteOrder(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId)); // Find existing order

        order.setDeleted(true); // Mark as deleted (assuming you have a 'deleted' field in your entity)
        orderRepo.save(order); // Save the changes to the database
    }
    
}
