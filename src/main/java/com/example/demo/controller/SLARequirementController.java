package com.example.demo.controller;

import com.example.demo.entity.SLARequirement;
import com.example.demo.service.SLARequirementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sla-requirements")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    @PostMapping
    public SLARequirement createRequirement(@RequestBody SLARequirement req) {
        return service.createRequirement(req);
    }

    @PutMapping("/{id}")
    public SLARequirement updateRequirement(@PathVariable Long id, @RequestBody SLARequirement req) {
        return service.updateRequirement(id, req);
    }

    @GetMapping("/{id}")
    public SLARequirement getRequirement(@PathVariable Long id) {
        return service.getRequirementByld(id);
    }

    @GetMapping
    public List<SLARequirement> getAllRequirements() {
        return service.getAllRequirements();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateRequirement(@PathVariable Long id) {
        service.deactivateRequirement(id);
    }
}
