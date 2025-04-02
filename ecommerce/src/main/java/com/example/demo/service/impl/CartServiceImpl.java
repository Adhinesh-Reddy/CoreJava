package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    

    @Override
    public Cart addCart(CartDto cartDto) {
        
        Cart cart = new Cart();

        BeanUtils.copyProperties(cartDto, cart);

        return cartRepo.save(cart);
    }

    @Override
    public Cart updateCart(Long cartId, CartDto cartDto) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("Address not found with id: "+cartId));

        // BeanUtils.copyProperties(cartDto, cart);

        cart.setTotalPrice(cartDto.getTotalPrice());

        Set<CartItem> cartItems = new HashSet<>();

        for(Long cartItemId: cartDto.getCartItemIds()){
            CartItem cartItem = cartItemRepo.findById(cartItemId).orElseThrow(()->new RuntimeException("Cart Item not found with id: "+cartItemId));
            cartItems.add(cartItem);
        }

        cart.setCartItems(cartItems);
        return cartRepo.save(cart);    
    }

    @Override
    public void softDeleteCart(Long cartId) {
        
        Cart cart = cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("Address not found with id: "+cartId));
        cart.setDeleted(true);
        cartRepo.save(cart);
    }
    
}
