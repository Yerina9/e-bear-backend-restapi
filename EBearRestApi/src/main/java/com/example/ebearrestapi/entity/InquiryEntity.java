package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "INQUIRY")
public class InquiryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer inquiryNo;
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
    @JoinColumn(name = "parentInquiryNo")
    private InquiryEntity parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<InquiryEntity> childrenList;
    @OneToMany(mappedBy = "inquiry")
    private List<MessageRoomEntity> messageRoomList;
}
