// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class SLARequirement {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String requirementName; // must match repository method

//     private boolean active;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {  // fixes setId() error
//         this.id = id;
//     }

//     public String getRequirementName() {
//         return requirementName;
//     }

//     public void setRequirementName(String requirementName) {
//         this.requirementName = requirementName;
//     }

//     public boolean isActive() {
//         return active;
//     }

//     public void setActive(boolean active) {
//         this.active = active;
//     }
// }
package com.example.demo.model;

public class SLARequirement {

    private Long id;
    private String requirementName;
    private String description;
    private Integer maxDeliveryDays;
    private Double qualityTarget;
    private Boolean active = true;

    public SLARequirement() {}

    public SLARequirement(String r, String d, Integer max, Double q) {
        this.requirementName = r;
        this.description = d;
        this.maxDeliveryDays = max;
        this.qualityTarget = q;
    }

    public Long getId() { return id; }
    public void setId(Long i) { this.id = i; }

    public String getRequirementName() { return requirementName; }
    public void setRequirementName(String r) { this.requirementName = r; }

    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }

    public Integer getMaxDeliveryDays() { return maxDeliveryDays; }

    public Double getQualityTarget() { return qualityTarget; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}
