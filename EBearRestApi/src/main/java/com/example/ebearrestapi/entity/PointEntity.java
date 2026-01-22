package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "POINT")
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointNo;
    private Integer useAmount;
    private LocalDateTime regDate;
    @ManyToOne
    @JoinColumn(name = "stateCodeNo")
    private StateCodeEntity stateCode;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
}
