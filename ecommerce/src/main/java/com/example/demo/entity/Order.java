package com.example.demo.entity;

import jakarta.persistence.*;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String email;
    private String date;
    private String order_status;
    private double total_amount;

    @JsonIgnore
    private boolean isDeleted=false;//soft delete flag

    @ManyToOne
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    private Payments payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderItems> orderItems = new HashSet<>();
}
