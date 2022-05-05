package com.budymann.OrderService.dataaccess;

import lombok.Cleanup;

import javax.persistence.*;

@Entity
@Table(name = "Order_")
public class Order {
    @Id
    private Long id;

    @Column(name="AMOUNT")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

}
