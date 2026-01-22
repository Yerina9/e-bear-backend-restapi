package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REVIEW")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewNo;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity board;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
