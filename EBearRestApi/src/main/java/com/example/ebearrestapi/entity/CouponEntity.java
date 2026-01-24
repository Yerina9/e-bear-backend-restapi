package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.CouponType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COUPON")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CouponEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponNo;
    
    @Column(nullable = false, length = 100)
    private String couponName;
    
    @Column(nullable = false)
    private Integer couponQuantity;
    
    @Column(nullable = false)
    private Double salePrice;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CouponType couponType;
    
    private LocalDateTime expiredDate;
    
    @Column(nullable = false)
    private Integer useAbledPrice;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryNo")
    private CategoryEntity category;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo")
    private UserEntity user;
    
    // 비즈니스 로직
    public boolean isExpired() {
        return expiredDate != null && LocalDateTime.now().isAfter(expiredDate);
    }
    
    public boolean isAvailable() {
        return !isExpired() && couponQuantity > 0;
    }
    
    public Integer calculateDiscountAmount(Integer price) {
        if (!isAvailable()) {
            return 0;
        }
        if (price < useAbledPrice) {
            return 0;
        }
        
        if (couponType == CouponType.PERCENT) {
            return (int) (price * (salePrice / 100.0));
        } else {
            return salePrice.intValue();
        }
    }
    
    public void use() {
        if (!isAvailable()) {
            throw new IllegalStateException("사용할 수 없는 쿠폰입니다.");
        }
        this.couponQuantity--;
    }
}
