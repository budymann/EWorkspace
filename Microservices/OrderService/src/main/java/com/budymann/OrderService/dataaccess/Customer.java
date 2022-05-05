package com.budymann.OrderService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private Long customerId;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;
}
