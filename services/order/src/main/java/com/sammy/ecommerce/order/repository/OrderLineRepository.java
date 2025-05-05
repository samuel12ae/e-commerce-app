package com.sammy.ecommerce.order.repository;

import com.sammy.ecommerce.order.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
