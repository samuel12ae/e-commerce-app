package com.sammy.ecommerce.util;

import com.sammy.ecommerce.dto.OrderLineRequest;
import com.sammy.ecommerce.dto.OrderLineResponse;
import com.sammy.ecommerce.entity.Order;
import com.sammy.ecommerce.entity.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .productId(request.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }

    // continue on 4:11:00
}
