package com.example.demo.controller;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class DeliveryEvaluationController {

    private final DeliveryEvaluationService service;

    public DeliveryEvaluationController(DeliveryEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryEvaluation createEvaluation(@RequestBody DeliveryEvaluation evaluation) {
        return service.createEvaluation(evaluation);
    }

    @GetMapping("/{id}")
    public DeliveryEvaluation getEvaluation(@PathVariable Long id) {
        return service.getEvaluationByld(id);
    }

    @GetMapping("/vendor/{vendorld}")
    public List<DeliveryEvaluation> getEvaluationsForVendor(@PathVariable Long vendorld) {
        return service.getEvaluationsForVendor(vendorld);
    }

    @GetMapping("/requirement/{reqld}")
    public List<DeliveryEvaluation> getEvaluationsForRequirement(@PathVariable Long reqld) {
        return service.getEvaluationsForRequirement(reqld);
    }
}
