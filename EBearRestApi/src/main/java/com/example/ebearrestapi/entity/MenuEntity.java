package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENU")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MenuEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuNo;
    
    @Column(nullable = false, length = 100)
    private String menuName;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentMenuNo")
    private MenuEntity parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MenuEntity> childList = new ArrayList<>();
    
    // 비즈니스 로직
    public void addChild(MenuEntity child) {
        childList.add(child);
        child.setParent(this);
    }
    
    public boolean isRootMenu() {
        return parent == null;
    }
}
