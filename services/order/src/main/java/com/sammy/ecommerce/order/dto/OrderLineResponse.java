package com.sammy.ecommerce.order.dto;

public record OrderLineResponse(
        Integer id,
        double quantity
) {
}
