package com.sammy.ecommerceapp.customer.repository;

import com.sammy.ecommerceapp.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
