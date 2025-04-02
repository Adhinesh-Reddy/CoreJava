package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.Cart;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.impl.CartServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    private CartRepo cartRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addCart(@Valid @RequestBody CartDto cartDto) {
        Cart addCart = cartServiceImpl.addCart(cartDto);

        if(addCart !=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addCart);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Not Added");
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<?> updateCart(@PathVariable Long cartId, @RequestBody CartDto cartDto){
        Cart updateCart = cartServiceImpl.updateCart(cartId, cartDto);

        if(updateCart!=null)
            return ResponseEntity.status(HttpStatus.OK).body("Cart updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not updated");
    }
    
    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<?> softDeleteCart(@PathVariable Long cartId){
        cartServiceImpl.softDeleteCart(cartId);
        return ResponseEntity.status(HttpStatus.OK).body("Cart deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCart(){
        return ResponseEntity.status(HttpStatus.OK).body(cartRepo.findAll());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> fetchSpecificCartId(@PathVariable Long cartId){
        return ResponseEntity.status(HttpStatus.OK).body(cartRepo.findById(cartId));
    }
}
