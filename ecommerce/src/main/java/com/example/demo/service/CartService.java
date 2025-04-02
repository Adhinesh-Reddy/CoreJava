package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.Cart;

public interface CartService {
    public Cart addCart(CartDto cartDto);
    public Cart updateCart(Long cartId, CartDto cartDto);
    public void softDeleteCart(Long cartId);
}
