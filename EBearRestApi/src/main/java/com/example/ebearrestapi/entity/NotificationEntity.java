package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer notificationNo;
    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity board;
}
