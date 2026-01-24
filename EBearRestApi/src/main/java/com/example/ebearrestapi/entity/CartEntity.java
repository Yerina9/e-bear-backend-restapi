package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CART")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CartEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;
    
    @Column(nullable = false)
    @Builder.Default
    private Integer quantity = 1;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNo", nullable = false)
    private ProductEntity product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productOptionNo")
    private ProductOptionEntity productOption;
    
    // 비즈니스 로직
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
    
    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
        if (this.quantity < 1) {
            this.quantity = 1;
        }
    }
    
    public Integer getTotalPrice() {
        int basePrice = product.getDiscountedPrice();
        if (productOption != null && productOption.getProductOptionPrice() != null) {
            basePrice += productOption.getProductOptionPrice();
        }
        return basePrice * quantity;
    }
}
