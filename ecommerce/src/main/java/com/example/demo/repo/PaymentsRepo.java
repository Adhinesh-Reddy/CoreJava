package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payments;

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Long>{
    
}
