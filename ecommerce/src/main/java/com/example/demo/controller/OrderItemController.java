package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItems;
import com.example.demo.repo.OrderItemRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.impl.OrderItemServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
     @Autowired
    private OrderItemServiceImpl orderItemServiceImpl;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderItemDto orderItemDto) {
        OrderItems addOrderItem = orderItemServiceImpl.addOrderItem(orderItemDto);

        if (addOrderItem != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(addOrderItem);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order item Not Added");
    }

    @PutMapping("/update/{orderItemId}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItemDto orderItemDto) {
        OrderItems updateOrderItem = orderItemServiceImpl.updateOrderItem(orderItemId, orderItemDto);

        if (updateOrderItem != null)
            return ResponseEntity.status(HttpStatus.OK).body("Order item updated successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order not updated");
    }

    @DeleteMapping("/delete/{orderItemId}")
    public ResponseEntity<?> softDeleteOrderItem(@PathVariable Long orderItemId) {
        orderItemServiceImpl.softDeleteOrderItem(orderItemId);
        return ResponseEntity.status(HttpStatus.OK).body("Order item deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrderItems() {
        return ResponseEntity.status(HttpStatus.OK).body(orderItemRepo.findAll());
    }

    @GetMapping("/get/{orderItemId}")
    public ResponseEntity<?> fetchSpecificOrderItemId(@PathVariable Long orderItemId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderItemRepo.findById(orderItemId).orElse(null));
    }
}
