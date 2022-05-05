package com.budymann.ProductService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "SHOPPING_CART_ITEM")
@Entity
@Getter
@Setter
public class ShoppingCartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOPPING_CART_ITEM_ID")
    private Long shoppingCartItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SESSION_ID")
    private SessionEntity session;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name="MODIFIED_AT")
    private LocalDateTime modifiedAt;
}
