package com.sammy.ecommerceapp.customer.dto;

import com.sammy.ecommerceapp.customer.entity.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer lastname is required")
        String lastname,
        @NotNull(message = "Customer email is not a valid email address")
        String email,
        Address address

) {
}
