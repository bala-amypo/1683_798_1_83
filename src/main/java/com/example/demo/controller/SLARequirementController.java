package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.SLARequirementService;
import com.example.demo.entity.SLARequirement;

import java.util.List;

@RestController
@RequestMapping("/sla")
public class SLARequirementController {

    private final SLARequirementService service;

    public SLARequirementController(SLARequirementService service) {
        this.service = service;
    }

    @PostMapping
    public SLARequirement create(@RequestBody SLARequirement sla) {
        return service.createRequirement(sla);
    }

    @PutMapping("/{id}")
    public SLARequirement update(@PathVariable Long id,
                                 @RequestBody SLARequirement sla) {
        return service.updateRequirement(id, sla);
    }

    @GetMapping("/{id}")
    public SLARequirement get(@PathVariable Long id) {
        return service.getRequirementById(id);
    }

    @GetMapping
    public List<SLARequirement> getAll() {
        return service.getAllRequirements();
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRequirement(id);
    }
}
