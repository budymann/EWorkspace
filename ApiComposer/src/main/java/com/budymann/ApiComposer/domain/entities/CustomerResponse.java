package com.budymann.ApiComposer.domain.entities;

import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Generated
@Data
public class CustomerResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
}
