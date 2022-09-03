package com.budymann.ProductService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class RelatedProductEntity {
    @EmbeddedId
    private Key key = new Key();

    @ManyToOne
    @MapsId("productId")
    private ProductEntity product;

    @ManyToOne
    @MapsId("relatedProductId")
    private ProductEntity relatedProduct;

    private boolean isActive;

    @Embeddable
    public static class Key implements Serializable {
        private Long productId;
        private Long relatedProductId;
    }
}
