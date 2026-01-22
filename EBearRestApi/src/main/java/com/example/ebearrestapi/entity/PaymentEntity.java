package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.PaymentType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentNo;
    private String name;
    private String phone;
    private String deliveryRequest;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private Integer paymentAmount;
    @OneToMany(mappedBy = "payment")
    private List<OrderListEntity> orderList;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
}
