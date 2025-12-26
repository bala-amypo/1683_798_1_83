// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.Date;

// @Entity
// public class DeliveryEvaluation {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Vendor vendor;

//     @ManyToOne
//     private SLARequirement slaRequirement;

//     private Integer actualDeliveryDays;
//     private Double qualityScore;
//     private Date evaluationDate;

//     private Boolean meetsDeliveryTarget;
//     private Boolean meetsQualityTarget;

//     public Long getId() {
//         return id;
//     }

//     public Vendor getVendor() {
//         return vendor;
//     }

//     public void setVendor(Vendor vendor) {
//         this.vendor = vendor;
//     }

//     public SLARequirement getSlaRequirement() {
//         return slaRequirement;
//     }

//     public void setSlaRequirement(SLARequirement slaRequirement) {
//         this.slaRequirement = slaRequirement;
//     }

//     public Integer getActualDeliveryDays() {
//         return actualDeliveryDays;
//     }

//     public void setActualDeliveryDays(Integer actualDeliveryDays) {
//         this.actualDeliveryDays = actualDeliveryDays;
//     }

//     public Double getQualityScore() {
//         return qualityScore;
//     }

//     public void setQualityScore(Double qualityScore) {
//         this.qualityScore = qualityScore;
//     }

//     public Boolean getMeetsDeliveryTarget() {
//         return meetsDeliveryTarget;
//     }

//     public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) {
//         this.meetsDeliveryTarget = meetsDeliveryTarget;
//     }

//     public Boolean getMeetsQualityTarget() {
//         return meetsQualityTarget;
//     }

//     public void setMeetsQualityTarget(Boolean meetsQualityTarget) {
//         this.meetsQualityTarget = meetsQualityTarget;
//     }
// }
package com.example.demo.model;

import java.time.LocalDate;

public class DeliveryEvaluation {

    private Long id;
    private Vendor vendor;
    private SLARequirement slaRequirement;
    private Integer actualDeliveryDays;
    private Double qualityScore;
    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;
    private LocalDate evaluationDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public void setSlaRequirement(SLARequirement req) { this.slaRequirement = req; }

    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public void setActualDeliveryDays(Integer d) { this.actualDeliveryDays = d; }

    public Double getQualityScore() { return qualityScore; }
    public void setQualityScore(Double s) { this.qualityScore = s; }

    public Boolean getMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public void setMeetsDeliveryTarget(Boolean m) { this.meetsDeliveryTarget = m; }

    public Boolean getMeetsQualityTarget() { return meetsQualityTarget; }
    public void setMeetsQualityTarget(Boolean m) { this.meetsQualityTarget = m; }

    public LocalDate getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(LocalDate d) { this.evaluationDate = d; }
}
