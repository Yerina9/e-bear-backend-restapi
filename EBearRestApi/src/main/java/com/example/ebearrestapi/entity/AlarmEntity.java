package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Validate;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALARM")
public class AlarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alarmNo;
    private String alarmContent;
    private LocalDateTime regDate;
    @Enumerated(EnumType.STRING)
    private Validate validate;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "stateNo")
    private StateCodeEntity stateCode;
}
