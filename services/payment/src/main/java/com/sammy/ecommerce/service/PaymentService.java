package com.sammy.ecommerce.service;

import com.sammy.ecommerce.dto.PaymentRequest;
import com.sammy.ecommerce.kafka.NotificationProducer;
import com.sammy.ecommerce.kafka.PaymentNotificationRequest;
import com.sammy.ecommerce.repository.PaymentRepository;
import com.sammy.ecommerce.util.PaymentMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(@Valid PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
