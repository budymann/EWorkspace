package com.budymann.ProductService.dataaccess;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Manufacturer")
@Getter
@Setter
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MANUFACTURER_NAME")
    private String manufacturerName;
}
