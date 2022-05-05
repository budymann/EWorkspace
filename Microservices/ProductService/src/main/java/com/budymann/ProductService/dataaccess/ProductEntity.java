package com.budymann.ProductService.dataaccess;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "RETAIL_PRICE")
    private BigDecimal retailPrice;

    @Column(name = "DISCOUNTED_PRICE")
    private BigDecimal discountedPrice;

    @Column(name = "IMAGE_LINK")
    private String imageLink;

    @Column(name = "STOCK")
    private int stock;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;
}
