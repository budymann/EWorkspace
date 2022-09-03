package com.budymann.CustomerService.domain.repository;

import com.budymann.CustomerService.dataaccess.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
