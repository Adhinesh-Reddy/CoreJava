package com.example.demo.service;

import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.OrderItems;

public interface OrderItemService {
    public OrderItems addOrderItem(OrderItemDto orderItemDto);
    public OrderItems updateOrderItem(Long orderItemId, OrderItemDto orderItemDto);
    public void softDeleteOrderItem(Long orderItemId);
}
