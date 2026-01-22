package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CONSULTATION")
public class ConsultaionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer consultationNo;
    private LocalDateTime regDate;
    @OneToMany(mappedBy = "consultation")
    private List<MessageEntity> messageList;
}
