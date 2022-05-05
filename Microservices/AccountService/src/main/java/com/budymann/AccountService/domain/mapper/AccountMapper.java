package com.budymann.AccountService.domain.mapper;

import com.budymann.AccountService.resource.model.AccountResponse;
import com.budymann.AccountService.resource.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {
    public AccountResponse mapAccountDab(com.budymann.AccountService.dataaccess.Account account){
        var result = new AccountResponse();
        BeanUtils.copyProperties(account, result);

        List<Customer> customerList = new ArrayList<>();

        account.getOwnedBy().stream().forEach(x -> {
            var customer = Customer.builder()
                    .customerId(x.getCustomerId())
                    .firstName(x.getFirstName())
                    .lastName(x.getLastName())
                    .build();
            customerList.add(customer);
        });

        result.setCustomers(customerList);

        return result;
    }
}
