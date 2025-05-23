package com.sammy.ecommerce.customer.dto;

import com.sammy.ecommerce.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        String id,

        @NotNull(message = "Customer firstname is required")
        @NotBlank(message = "Customer firstname is required")
        String firstname,

        @NotNull(message = "Customer lastname is required")
        @NotBlank(message = "Customer lastname is required")
        String lastname,

        @NotNull(message = "Customer email is required")
        @NotBlank(message = "Customer email is required")
        @Email(message = "Customer email is not a valid email address")
        String email,

        Address address

) {
}
