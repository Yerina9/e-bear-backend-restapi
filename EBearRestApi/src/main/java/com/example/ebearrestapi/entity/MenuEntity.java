package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MENU")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuNo;
    private String menuName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentMenuNo")
    private MenuEntity parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<MenuEntity> childList;
}
