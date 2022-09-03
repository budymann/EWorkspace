package com.budymann.ApiComposer.resource;

import com.budymann.ApiComposer.domain.entities.CustomerResponse;
import com.budymann.ApiComposer.domain.services.AccountService;
import com.budymann.ApiComposer.domain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("composer")
public class ComposerResource {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/compose")
    public String compose() throws URISyntaxException, IOException, InterruptedException, ExecutionException {

        var account = accountService.getAccount("062181", "12344321");

        var customers = account.getCustomers();

        List<CompletableFuture<CustomerResponse>> customerFutures = new ArrayList<>();

        for(var customer : customers) {
            customerFutures.add(
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return customerService.getCustomer(customer.getCustomerId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
            );
        }

        customerFutures.forEach(CompletableFuture::join);

        for(var x : customerFutures){
            System.out.println(x.get());
        }



        return "Hello";
    }

    @GetMapping("/hello")
    public String he() throws URISyntaxException, IOException, InterruptedException, ExecutionException {


        return "Hello";
    }

    public CustomerResponse printObject(CustomerResponse customerResponse){
        System.out.println(customerResponse.getFirstName());
        return customerResponse;
    }
}
