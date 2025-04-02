package com.example.demo.service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.CartItem;

public interface CartItemService {
    public CartItem addCart(CartItemDto cartItemDto);
    public CartItem updateCart(Long cartItemId, CartItemDto cartItemDto);
    public void softDeleteCart(Long cartItemId);
}
