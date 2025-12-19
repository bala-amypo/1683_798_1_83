package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.SLARequirement;

public interface SLARequirementRepository extends JpaRepository<SLARequirement, Long> {
    boolean existsByRequirementName(String requirementName);
}
