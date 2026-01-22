package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productNo;
    private String productName;
    private Integer price;
    private Double saleRatio;
    private String description;
    private LocalDateTime regDate;
    private Integer inventory;
    private Integer deliveryPrice;
    private Double deliveryDate;
    @OneToMany(mappedBy = "product")
    private List<ProductOptionEntity> productOptionList;
    @OneToMany(mappedBy = "product")
    private List<CartEntity> cartList;
    @OneToMany(mappedBy = "product")
    private List<CurrentViewProductEntity> currentViewProductList;
    @OneToMany(mappedBy = "product")
    private List<FileEntity> fileList;
    @OneToMany(mappedBy = "product")
    private List<InquiryEntity> inquiryList;
    @OneToMany(mappedBy = "product")
    private List<OrderListEntity> orderList;
    @OneToMany(mappedBy = "product")
    private List<ReportEntity> reportList;
    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> reviewList;
    @OneToMany(mappedBy = "product")
    private List<WishListEntity> wishList;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "categoryNo")
    private CategoryEntity category;
}
