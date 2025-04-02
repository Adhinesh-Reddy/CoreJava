package com.example.demo.service;

import com.example.demo.dto.PaymentsDto;
import com.example.demo.entity.Payments;

public interface PaymentService {
    public Payments addPayment(PaymentsDto paymentsDto);
    public Payments updatePayment(Long paymentId, PaymentsDto paymentsDto);
    public void softDeletePayment(Long paymentId);
}
