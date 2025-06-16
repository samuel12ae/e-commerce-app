package com.sammy.ecommerce.order.util;

import com.sammy.ecommerce.order.dto.OrderLineRequest;
import com.sammy.ecommerce.order.dto.OrderLineResponse;
import com.sammy.ecommerce.order.entity.Order;
import com.sammy.ecommerce.order.entity.OrderLine;
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
