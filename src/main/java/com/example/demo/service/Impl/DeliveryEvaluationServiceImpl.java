package com.example.demo.service.impl;

import com.example.demo.entity.DeliveryEvaluation;
import com.example.demo.entity.SLARequirement;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        Vendor vendor = eval.getVendor();
        if (vendor == null || !vendor.getActive()) {
            throw new IllegalStateException("active vendors");
        }

        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException(">= 0");
        }

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score");
        }

        SLARequirement sla = eval.getSlaRequirement();

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays()
        );

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getMinQualityScore()
        );

        return repo.save(eval);
    }

    @Override
    public DeliveryEvaluation getEvaluationById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return repo.findByVendorld(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementId) {
        return repo.findBySlaRequirementld(requirementId);
    }
}
