package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "REPORT")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reportNo;
    @ManyToOne
    @JoinColumn(name = "stateCodeNo")
    private StateCodeEntity stateCode;
    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity board;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentReportNo")
    private ReportEntity parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ReportEntity> childList;
}
