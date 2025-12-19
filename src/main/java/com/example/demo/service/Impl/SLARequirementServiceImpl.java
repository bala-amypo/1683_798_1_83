package com.example.demo.service.impl;

import com.example.demo.entity.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

import java.util.List;

public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    public SLARequirement createRequirement(SLARequirement req) {
        if (req.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days");
        }
        if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 100) {
            throw new IllegalArgumentException("between 0 and 100");
        }
        return repository.save(req);
    }

    public SLARequirement updateRequirement(Long id, SLARequirement req) {
        SLARequirement existing = getRequirementByld(id);
        existing.setRequirementName(req.getRequirementName());
        existing.setDescription(req.getDescription());
        existing.setMaxDeliveryDays(req.getMaxDeliveryDays());
        existing.setMinQualityScore(req.getMinQualityScore());
        return repository.save(existing);
    }

    public SLARequirement getRequirementByld(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    public List<SLARequirement> getAllRequirements() {
        return repository.findAll();
    }

    public void deactivateRequirement(Long id) {
        SLARequirement req = getRequirementByld(id);
        req.setActive(false);
        repository.save(req);
    }
}
