package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sla_requirements", uniqueConstraints = @UniqueConstraint(columnNames = "requirementName"))
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String requirementName;

    private String description;
    private Integer maxDeliveryDays;
    private Double minQualityScore;

    private Boolean active = true;

    // getters and setters
}
