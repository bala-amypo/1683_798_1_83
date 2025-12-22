package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SLARequirement;
import com.example.demo.service.SLARequirementService;

@RestController
@RequestMapping("/sla")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    @PostMapping
    public SLARequirement create(@RequestBody SLARequirement sla) {
        return service.createSLARequirement(sla);
    }

    @GetMapping
    public List<SLARequirement> getAll() {
        return service.getAllSLARequirements();
    }

    @GetMapping("/{id}")
    public SLARequirement getById(@PathVariable Long id) {
        return service.getSLARequirementById(id);
    }

    @PutMapping("/{id}")
    public SLARequirement update(@PathVariable Long id, @RequestBody SLARequirement sla) {
        return service.updateSLARequirement(id, sla);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSLARequirement(id);
    }
}
