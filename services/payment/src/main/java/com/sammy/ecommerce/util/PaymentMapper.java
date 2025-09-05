package com.sammy.ecommerce.util;

import com.sammy.ecommerce.dto.PaymentRequest;
import com.sammy.ecommerce.entity.Payment;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentMapper {

    public Payment toPayment(@Valid PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }
}
