package com.sammy.ecommerce.customer.dto;

import com.sammy.ecommerce.customer.entity.Address;

public record CustomerResponse(

        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}
