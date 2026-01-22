package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EVENT")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventNo;
    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardEntity board;
}
