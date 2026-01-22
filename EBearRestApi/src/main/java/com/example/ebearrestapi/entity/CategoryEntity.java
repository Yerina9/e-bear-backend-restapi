package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryNo;
    private String categoryName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCategoryNo")
    private CategoryEntity parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CategoryEntity> childrenList;
    @OneToMany(mappedBy = "category")
    private List<CouponEntity> couponList;
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> productList;
}
