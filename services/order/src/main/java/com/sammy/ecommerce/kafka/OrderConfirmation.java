package com.sammy.ecommerce.kafka;

import com.sammy.ecommerce.customer.CustomerResponse;
import com.sammy.ecommerce.order.entity.PaymentMethod;
import com.sammy.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
