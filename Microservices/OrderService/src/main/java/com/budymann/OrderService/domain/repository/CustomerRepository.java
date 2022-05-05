package com.budymann.OrderService.domain.repository;

import com.budymann.OrderService.dataaccess.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
