package com.budymann.AccountService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name="ACCOUNT_ID")
    private Long accountId;

    @Column(name="ACCOUNT_NO")
    private String accountNo;

    @Column(name="BSB")
    private String bsb;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @ManyToMany
    @JoinTable(
        name = "ownedBy",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    private Set<Customer> ownedBy;
}
