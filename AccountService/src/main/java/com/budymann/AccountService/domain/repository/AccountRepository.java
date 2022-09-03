package com.budymann.AccountService.domain.repository;

import com.budymann.AccountService.dataaccess.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByBsbAndAccountNo(String bsb, String accountNo);
}
