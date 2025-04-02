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
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    private double discount;
    private double productPrice;
    private int quantity;

    @JsonIgnore
    private boolean isDeleted=false;//soft delete flag

    @ManyToOne
    @JoinColumn(name="cartId", referencedColumnName = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "product_id")
    private Product product;
}
