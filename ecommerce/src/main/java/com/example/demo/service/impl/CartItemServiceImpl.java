package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.CartItem;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Override
    public CartItem addCart(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();

        BeanUtils.copyProperties(cartItemDto, cartItem);

        return cartItemRepo.save(cartItem);
    
    }
    

    @Override
    public CartItem updateCart(Long cartItemId, CartItemDto cartItemDto) {
        CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart item not found with id: " + cartItemId));

        BeanUtils.copyProperties(cartItemDto, cartItem);

        return cartItemRepo.save(cartItem);
    }

    @Override
    public void softDeleteCart(Long cartItemId) {
        CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow(() -> new RuntimeException("Cart item not found with id: " + cartItemId));
        cartItem.setDeleted(true);
        cartItemRepo.save(cartItem);
    }
    
}
