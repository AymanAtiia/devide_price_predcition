package com.example.devicepredictions.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specifications;

    @Column
    private Double predictedPrice;
}

