package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Order;

public interface OrderService {
    public Order addOrder(OrderDto orderDto);
    public Order updateOrder(Long orderId, OrderDto orderDto);
    public void softDeleteOrder(Long orderId);
}
