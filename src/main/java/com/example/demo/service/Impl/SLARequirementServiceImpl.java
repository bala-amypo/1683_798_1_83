package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

@Service   // 🔥 THIS IS THE MOST IMPORTANT LINE
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement createSLARequirement(SLARequirement sla) {
        return repository.save(sla);
    }

    @Override
    public List<SLARequirement> getAllSLARequirements() {
        return repository.findAll();
    }

    @Override
    public SLARequirement getSLARequirementById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SLARequirement updateSLARequirement(Long id, SLARequirement sla) {
        sla.setId(id);
        return repository.save(sla);
    }

    @Override
    public void deleteSLARequirement(Long id) {
        repository.deleteById(id);
    }
}
