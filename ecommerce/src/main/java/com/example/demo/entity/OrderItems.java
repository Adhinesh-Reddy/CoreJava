package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    private double discount;
    private double orderedProductPrice;
    private int quantity;

    @JsonIgnore
    private boolean isDeleted=false;//soft delete flag

    @ManyToOne
    @JoinColumn(name="productId", referencedColumnName = "productId")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name="orderId",  referencedColumnName = "orderId")
    private Order order;
}
