package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CART")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartNo;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
