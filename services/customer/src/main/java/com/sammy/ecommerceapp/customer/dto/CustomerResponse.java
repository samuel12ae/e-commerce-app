package com.sammy.ecommerceapp.customer.dto;

import com.sammy.ecommerceapp.customer.entity.Address;

public record CustomerResponse(

        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
