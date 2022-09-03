package com.budymann.ApiComposer.domain.entities;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Generated
@Data
public class AccountResponse {
    private String accountId;
    private String accountNo;
    private String bsb;
    private String productName;
    private List<Customer> customers;
}