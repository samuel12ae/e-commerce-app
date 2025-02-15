package com.sammy.ecommerceapp.customer.utils;

import com.sammy.ecommerceapp.customer.dto.CustomerResponse;
import com.sammy.ecommerceapp.customer.entity.Customer;
import com.sammy.ecommerceapp.customer.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
