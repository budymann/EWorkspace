package com.budymann.AccountService.resource.model;

import lombok.Data;
import lombok.Generated;

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
