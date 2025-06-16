package com.sammy.ecommerce.order.service;

import com.sammy.ecommerce.customer.CustomerClient;
import com.sammy.ecommerce.exception.BusinessException;
import com.sammy.ecommerce.kafka.OrderConfirmation;
import com.sammy.ecommerce.kafka.OrderProducer;
import com.sammy.ecommerce.order.dto.OrderLineRequest;
import com.sammy.ecommerce.order.dto.OrderRequest;
import com.sammy.ecommerce.order.dto.OrderResponse;
import com.sammy.ecommerce.order.repository.OrderRepository;
import com.sammy.ecommerce.order.util.OrderMapper;
import com.sammy.ecommerce.product.ProductClient;
import com.sammy.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        // check the customer --> feignClient
        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(
                        "Cannot create order:: No customer exists with provided ID:: " + request.customerId()
                        )
                );

        // purchase the product --> RESTTemplate(harder then feignClient)
        var purchasedProducts = productClient.purchaseProducts(request.products());

        // persist order
        var order = repository.save(mapper.toOrder(request));

        // persist order lines
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // todo start payment process

        // send the order confirmation --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::toOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No order found with the provided ID: %d", orderId)
                )
        );
    }
}
