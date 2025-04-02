package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "discount is required")
    private Double discount;
    @NotBlank(message = "image is required")
    private String image;
    @NotNull(message = "price is required")
    private Double price;
    @NotBlank(message = "productName is required")
    private String productName;
    @NotNull(message = "quantity is required")
    private int quantity;
    @NotNull(message = "specialPrice is required")
    private Double specialPrice;
    @NotNull(message = "Seller Id is required")
    private int sellerId;

    @JsonIgnore
	private boolean isDeleted=false;//soft delete flag

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartItem> cartItems = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderItems> orderItems = new HashSet<>();
}
