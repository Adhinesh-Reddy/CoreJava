package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.CartItem;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.service.impl.CartItemServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {
    @Autowired
    private CartItemServiceImpl cartItemServiceImpl;

    @Autowired
    private CartItemRepo cartItemRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addCartItem(@Valid @RequestBody CartItemDto cartItemDto) {
        CartItem addCartItem = cartItemServiceImpl.addCart(cartItemDto);

        if(addCartItem !=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addCartItem);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Item Not Added");
    }

    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<?> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItemDto cartItemDto){
        CartItem updateCartItem = cartItemServiceImpl.updateCart(cartItemId, cartItemDto);

        if(updateCartItem!=null)
            return ResponseEntity.status(HttpStatus.OK).body("Cart Item updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Item not updated");
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<?> softDeleteCartItem(@PathVariable Long cartItemId){
        cartItemServiceImpl.softDeleteCart(cartItemId);
        return ResponseEntity.status(HttpStatus.OK).body("Cart Item deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCartItems(){
        return ResponseEntity.status(HttpStatus.OK).body(cartItemRepo.findAll());
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<?> fetchSpecificCartItemId(@PathVariable Long cartItemId){
        return ResponseEntity.status(HttpStatus.OK).body(cartItemRepo.findById(cartItemId));
    }
}
