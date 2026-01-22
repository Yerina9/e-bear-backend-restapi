package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STATE_CODE")
public class StateCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateCodeNo;
    private String stateName;
    @OneToMany(mappedBy = "stateCode")
    private List<AlarmEntity> alarmList;
    @OneToMany(mappedBy = "stateCode")
    private List<InquiryEntity> inquiryList;
    @OneToMany(mappedBy = "stateCode")
    private List<OrderListEntity> orderList;
    @OneToMany(mappedBy = "stateCode")
    private List<PointEntity> pointList;
    @OneToMany(mappedBy = "stateCode")
    private List<ReportEntity> reportList;
}
