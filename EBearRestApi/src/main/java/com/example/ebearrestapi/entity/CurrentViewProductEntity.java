package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CURRENT_VIEW_PRODUCT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CurrentViewProductEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currentViewProductNo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNo", nullable = false)
    private ProductEntity product;
}
