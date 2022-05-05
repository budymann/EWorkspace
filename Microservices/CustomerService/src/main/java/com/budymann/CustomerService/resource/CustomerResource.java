package com.budymann.CustomerService.resource;

import com.budymann.CustomerService.domain.repository.CustomerRepository;
import com.budymann.CustomerService.resource.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("{customerId}/customer")
    public CustomerResponse getCustomer(@PathVariable String customerId) throws Exception {
        var customer = customerRepository.getById(Long.parseLong(customerId));

        var rand = Math.random() * 100;


        if(customer.getCustomerId() == 1 && rand > 50 ){
            throw new Exception("We don't serve your kind here");
        }

        return CustomerResponse.builder()
                .customerId(customer.getCustomerId())
                .dateOfBirth(customer.getDateOfBirth())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName()).build();
    }
}
