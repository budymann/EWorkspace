package com.budymann.ProductService.dataaccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "CATEGORY_PATH")
    private String categoryPath;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENT_ID")
    private CategoryEntity parent;

    @OneToMany(mappedBy = "parent")
    private Set<CategoryEntity> children;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> products;
}
