package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Order;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.impl.OrderServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDto orderDto) {
        Order addOrder = orderServiceImpl.addOrder(orderDto);

        if (addOrder != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addOrder);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order Not Added");
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        Order updateOrder = orderServiceImpl.updateOrder(orderId, orderDto);

        if (updateOrder != null)
            return ResponseEntity.status(HttpStatus.OK).body("Order updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order not updated");
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> softDeleteOrder(@PathVariable Long orderId) {
        orderServiceImpl.softDeleteOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrder() {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findAll());
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity<?> fetchSpecificOrderId(@PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepo.findById(orderId).orElse(null));
    }

}
