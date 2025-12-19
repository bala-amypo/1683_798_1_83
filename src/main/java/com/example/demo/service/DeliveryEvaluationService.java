package com.example.demo.service;

import com.example.demo.entity.DeliveryEvaluation;
import java.util.List;

public interface DeliveryEvaluationService {
    DeliveryEvaluation createEvaluation(DeliveryEvaluation evaluation);
    DeliveryEvaluation getEvaluationByld(Long id);
    List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorld);
    List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementld);
}
