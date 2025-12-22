package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SLARequirement;

public interface SLARequirementService {

    SLARequirement createSLARequirement(SLARequirement sla);

    List<SLARequirement> getAllSLARequirements();

    SLARequirement getSLARequirementById(Long id);

    SLARequirement updateSLARequirement(Long id, SLARequirement sla);

    void deleteSLARequirement(Long id);
}
