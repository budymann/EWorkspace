package com.budymann.CustomerService.resource.model;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Generated
@Data
@Builder
public class CustomerResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
}
