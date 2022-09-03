package com.budymann.OrderService.domain.repository;

import com.budymann.OrderService.dataaccess.Customer;
import com.budymann.OrderService.dataaccess.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
