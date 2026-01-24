package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_LIST", indexes = {
    @Index(name = "idx_payment", columnList = "paymentNo"),
    @Index(name = "idx_state", columnList = "stateCodeNo")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderListEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderListNo;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private Integer price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentNo", nullable = false)
    private PaymentEntity payment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartNo", nullable = false)
    private CartEntity cart;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stateCodeNo")
    private StateCodeEntity stateCode;
    
    // 비즈니스 로직
    public Integer getTotalPrice() {
        return price * quantity;
    }
}
