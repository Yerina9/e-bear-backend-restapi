package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.CouponType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COUPON")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponNo;
    private String couponName;
    private Integer couponQuantity;
    private Double salePrice;
    @Enumerated(EnumType.STRING)
    private CouponType couponType;
    private LocalDateTime expriredDate;
    private Integer useAbledPrice;
    @ManyToOne
    @JoinColumn(name = "categoryNo")
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
}
