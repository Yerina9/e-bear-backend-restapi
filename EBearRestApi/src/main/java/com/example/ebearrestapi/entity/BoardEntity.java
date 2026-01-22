package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BOARD")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNo;
    private String title;
    @Lob
    private String content;
    private Integer viewCnt;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @OneToMany(mappedBy = "board")
    private List<EventEntity> eventList;
    @OneToMany(mappedBy = "board")
    private List<InquiryEntity> inquiryList;
    @OneToMany(mappedBy = "board")
    private List<NotificationEntity> notificationList;
    @OneToMany(mappedBy = "board")
    private List<ReportEntity> reportList;
    @OneToMany(mappedBy = "board")
    private List<ReviewEntity> reviewList;
}
