package com.budymann.AccountService.resource;

import com.budymann.AccountService.domain.mapper.AccountMapper;
import com.budymann.AccountService.domain.repository.AccountRepository;
import com.budymann.AccountService.resource.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("{bsb}/{accountNo}/account")
    public AccountResponse getAccount(@PathVariable String bsb, @PathVariable String accountNo){
        var acc =  accountRepository.findByBsbAndAccountNo(bsb, accountNo);
        return accountMapper.mapAccountDab(acc);
    }
}
