package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_OPTION")
public class ProductOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productOptionNo;
    private String productOptionName;
    private String productOptionPrice;
    private String productOptionQuantity;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
