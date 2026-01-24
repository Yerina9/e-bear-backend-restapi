package com.example.ebearrestapi.entity;

import com.example.ebearrestapi.etc.Validate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ALARM")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AlarmEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmNo;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String alarmContent;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Validate validate = Validate.UNCHECK;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stateNo")
    private StateCodeEntity stateCode;
    
    // 비즈니스 로직
    public void markAsRead() {
        this.validate = Validate.CHECK;
    }
}
