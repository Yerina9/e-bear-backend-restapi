package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Validate;
import jakarta.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer messageNo;
    private String message;
    @Enumerated(EnumType.STRING)
    private Validate validate;
    @ManyToOne
    @JoinColumn(name = "messageRoomNo")
    private MessageRoomEntity messageRoom;
    @ManyToOne
    @JoinColumn(name = "consultationNo")
    private ConsultaionEntity consultation;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
}
