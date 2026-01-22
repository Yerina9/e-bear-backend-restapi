package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_LIST")
public class OrderListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderListNo;
    private LocalDateTime regDate;
    @ManyToOne
    @JoinColumn(name = "paymentNo")
    private PaymentEntity payment;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "stateCodeNo")
    private StateCodeEntity stateCode;
}
