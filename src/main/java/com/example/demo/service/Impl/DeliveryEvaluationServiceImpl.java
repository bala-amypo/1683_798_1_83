package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.DeliveryEvaluationService;

import java.util.List;

public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository repo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository repo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo) {
        this.repo = repo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        if (!eval.getVendor().getActive()) {
            throw new IllegalStateException("active vendors");
        }
        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException(">= 0");
        }
        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score");
        }

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= eval.getSlaRequirement().getMaxDeliveryDays()
        );
        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= eval.getSlaRequirement().getMinQualityScore()
        );

        return repo.save(eval);
    }

    public DeliveryEvaluation getEvaluationByld(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorld) {
        return repo.findByVendorld(vendorld);
    }

    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementld) {
        return repo.findBySlaRequirementld(requirementld);
    }
}
