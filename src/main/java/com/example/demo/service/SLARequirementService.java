package com.example.demo.service;

import com.example.demo.entity.SLARequirement;
import java.util.List;

public interface SLARequirementService {
    SLARequirement createRequirement(SLARequirement sla);
    SLARequirement updateRequirement(Long id, SLARequirement sla);
    SLARequirement getRequirementById(Long id);
    List<SLARequirement> getAllRequirements();
    void deactivateRequirement(Long id);
}
