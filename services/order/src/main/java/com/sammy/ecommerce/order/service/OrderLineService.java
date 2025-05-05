package com.sammy.ecommerce.order.service;

import com.sammy.ecommerce.order.dto.OrderLineRequest;
import com.sammy.ecommerce.order.repository.OrderLineRepository;
import com.sammy.ecommerce.order.util.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest request) {
        var orderLine = mapper.toOrderLine(request);
        return repository.save(orderLine).getId();
    }
}
