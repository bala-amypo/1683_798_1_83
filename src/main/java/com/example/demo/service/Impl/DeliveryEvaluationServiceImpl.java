// package com.example.demo.service.impl;

// import com.example.demo.entity.DeliveryEvaluation;
// import com.example.demo.repository.DeliveryEvaluationRepository;
// import com.example.demo.service.DeliveryEvaluationService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

//     private final DeliveryEvaluationRepository repo;

//     public DeliveryEvaluationServiceImpl(DeliveryEvaluationRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation) {
//         return repo.save(evaluation);
//     }

//     @Override
//     public DeliveryEvaluation getEvaluationById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public List<DeliveryEvaluation> getAllEvaluations() {
//         return repo.findAll();
//     }

//     @Override
//     public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
//         return repo.findByVendor_Id(vendorId);
//     }

//     @Override
//     public List<DeliveryEvaluation> getEvaluationsForRequirement(Long slaRequirementId) {
//         return repo.findBySlaRequirement_Id(slaRequirementId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DeliveryEvaluationService;

import java.util.List;

public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository evaluationRepo;
    private final VendorRepository vendorRepo;
    private final SLARequirementRepository slaRepo;

    public DeliveryEvaluationServiceImpl(
            DeliveryEvaluationRepository evaluationRepo,
            VendorRepository vendorRepo,
            SLARequirementRepository slaRepo
    ) {
        this.evaluationRepo = evaluationRepo;
        this.vendorRepo = vendorRepo;
        this.slaRepo = slaRepo;
    }

    @Override
    public DeliveryEvaluation createEvaluation(DeliveryEvaluation eval) {

        Vendor vendor = vendorRepo.findById(eval.getVendor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found"));

        if (!vendor.getActive()) {
            throw new IllegalStateException("Evaluations allowed only for active vendors");
        }

        SLARequirement sla = slaRepo.findById(eval.getSlaRequirement().getId())
                .orElseThrow(() -> new IllegalArgumentException("SLA not found"));

        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException("Actual delivery days must be >= 0");
        }

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score must be between 0 and 100");
        }

        eval.setMeetsDeliveryTarget(eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays());
        eval.setMeetsQualityTarget(eval.getQualityScore() >= sla.getQualityTarget());

        return evaluationRepo.save(eval);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
        return evaluationRepo.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getEvaluationsForRequirement(Long reqId) {
        return evaluationRepo.findBySlaRequirementId(reqId);
    }
}
