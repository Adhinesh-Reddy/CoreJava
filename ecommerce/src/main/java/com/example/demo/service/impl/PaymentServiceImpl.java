package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentsDto;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Order;
import com.example.demo.entity.Payments;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.PaymentsRepo;
import com.example.demo.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    
    @Autowired
    private PaymentsRepo paymentsRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Payments addPayment(PaymentsDto paymentsDto) {
        Payments payments = new Payments();

        BeanUtils.copyProperties(paymentsDto, payments); // Copy properties from DTO to entity

        return paymentsRepo.save(payments); // Save the entity to the database and return it
    }

    @Override
    public Payments updatePayment(Long paymentId, PaymentsDto paymentsDto) {
        Payments payments = paymentsRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId)); // Find existing payment
        
        BeanUtils.copyProperties(paymentsDto, payments); // Copy properties from DTO to existing entity

        Set<Order> orders = new HashSet<>();
        
        for(Long orderId: paymentsDto.getOrderIds()){
            Order order = orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("CartItem not found with id: "+ orderId));
            orders.add(order);
        }

        payments.setOrders(orders);
        return paymentsRepo.save(payments); // Save the updated entity to the database and return it
    }

    @Override
    public void softDeletePayment(Long paymentId) {
        Payments payments = paymentsRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId)); // Find existing payment

        payments.setDeleted(true); // Mark as deleted (assuming you have a 'deleted' field in your entity)
        paymentsRepo.save(payments); // Save the changes to the database
    }



}
