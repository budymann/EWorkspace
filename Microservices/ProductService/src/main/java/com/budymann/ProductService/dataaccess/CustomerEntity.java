package com.budymann.ProductService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToOne(mappedBy = "customer")
    private SessionEntity session;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name="MODIFIED_AT")
    private LocalDateTime modifiedAt;
}
