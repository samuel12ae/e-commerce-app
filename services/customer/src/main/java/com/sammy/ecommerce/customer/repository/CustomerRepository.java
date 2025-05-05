package com.sammy.ecommerce.customer.repository;

import com.sammy.ecommerce.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
