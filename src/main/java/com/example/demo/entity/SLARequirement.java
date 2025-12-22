package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requirementName; // must match repository method

    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {  // fixes setId() error
        this.id = id;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
