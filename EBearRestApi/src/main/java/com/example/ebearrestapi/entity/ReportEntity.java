package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REPORT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReportEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stateCodeNo")
    private StateCodeEntity stateCode;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardNo")
    private BoardEntity board;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productNo")
    private ProductEntity product;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentReportNo")
    private ReportEntity parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ReportEntity> childList = new ArrayList<>();
    
    // 비즈니스 로직
    public void addReply(ReportEntity reply) {
        childList.add(reply);
        reply.setParent(this);
    }
}
