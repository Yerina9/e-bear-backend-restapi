package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.PaymentType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CURRENT_VIEW_PRODUCT")
public class CurrentViewProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer currentViewProductNo;
    private LocalDateTime viewDate;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
