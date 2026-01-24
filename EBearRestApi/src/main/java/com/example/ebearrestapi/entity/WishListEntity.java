package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "WISH_LIST")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class WishListEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListNo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNo", nullable = false)
    private ProductEntity product;
}
