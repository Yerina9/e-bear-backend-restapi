package com.example.ebearrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EVENT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class EventEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventNo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardNo", nullable = false)
    private BoardEntity board;
}
