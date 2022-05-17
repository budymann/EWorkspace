package com.budymann.ProductService.dataaccess;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ProductAttribute")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAttributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany( mappedBy="productAttribute", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<ProductProductAttributeEntity> products = new HashSet<>();
}
