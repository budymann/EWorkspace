package com.budymann.ProductService.dataaccess;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

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

    @OneToMany( mappedBy="product", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<RelatedProductEntity> relatedProducts = new HashSet<>();

    @Column(name = "TAG")
    private String productTags;

    @Column(name = "Model")
    private String model;

}
