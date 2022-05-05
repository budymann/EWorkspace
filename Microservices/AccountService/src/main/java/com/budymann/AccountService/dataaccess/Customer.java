package com.budymann.AccountService.dataaccess;

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
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @ManyToMany(mappedBy = "ownedBy")
    private Set<Account> accounts;
}
