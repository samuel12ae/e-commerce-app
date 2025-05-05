package com.sammy.ecommerce.customer.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
