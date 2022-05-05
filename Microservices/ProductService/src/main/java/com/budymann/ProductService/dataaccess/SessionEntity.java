package com.budymann.ProductService.dataaccess;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Session")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SESSION_ID")
    private Long sessionId;

    @Column(name = "SESSION_KEY")
    private UUID sessionKey;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "session")
    public Set<ShoppingCartItemEntity> shoppingCartItems;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name="MODIFIED_AT")
    private LocalDateTime modifiedAt;
}
