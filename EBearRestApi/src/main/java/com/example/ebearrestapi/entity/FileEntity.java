package com.example.ebearrestapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FILE")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fileNo;
    private String fileLocation;
    private String originalFileName;
    private String saveFileName;
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity product;
}
