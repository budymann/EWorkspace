package com.budymann.OrderService.domain.repository;

import com.budymann.OrderService.dataaccess.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
