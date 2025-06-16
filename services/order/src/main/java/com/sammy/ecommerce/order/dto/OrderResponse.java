package com.sammy.ecommerce.order.dto;

import com.sammy.ecommerce.order.entity.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
