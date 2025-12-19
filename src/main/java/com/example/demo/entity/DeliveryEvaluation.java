package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_evaluations")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private SLARequirement slaRequirement;

    private Integer actualDeliveryDays;
    private Double qualityScore;

    private Date evaluationDate;

    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;

    // getters and setters
}
