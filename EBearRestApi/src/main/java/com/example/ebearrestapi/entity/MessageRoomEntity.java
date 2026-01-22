package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MESSAGE_ROOM")
public class MessageRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer messageRoomNo;
    private LocalDateTime regDate;
    @OneToMany(mappedBy = "messageRoom")
    private List<MessageEntity> messageList;
    @ManyToOne
    @JoinColumn(name = "inquiryNo")
    private InquiryEntity inquiry;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity user;
}
