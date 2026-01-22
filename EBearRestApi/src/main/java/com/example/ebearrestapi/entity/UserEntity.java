package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo;
    private String userId;
    private String password;
    private String userName;
    private String post;
    private String address;
    private String addressDetails;
    private String mobile;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<AlarmEntity> alarmList;
    @OneToMany(mappedBy = "user")
    private List<BoardEntity> boardList;
    @OneToMany(mappedBy = "user")
    private List<CartEntity> cartList;
    @OneToMany(mappedBy = "user")
    private List<CouponEntity> couponList;
    @OneToMany(mappedBy = "user")
    private List<CurrentViewProductEntity> currentViewProductList;
    @OneToMany(mappedBy = "user")
    private List<MessageEntity> messageList;
    @OneToMany(mappedBy = "user")
    private List<MessageRoomEntity> messageRoomList;
    @OneToMany(mappedBy = "user")
    private List<PaymentEntity> paymentList;
    @OneToMany(mappedBy = "user")
    private List<PointEntity> pointList;
    @OneToMany(mappedBy = "user")
    private List<ProductEntity> productList;
    @OneToMany(mappedBy = "user")
    private List<ReviewEntity> reviewList;
    @OneToMany(mappedBy = "user")
    private List<WishListEntity> wishList;
}
