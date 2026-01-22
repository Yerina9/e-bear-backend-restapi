package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "WISH_LIST")
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wishListNo;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
