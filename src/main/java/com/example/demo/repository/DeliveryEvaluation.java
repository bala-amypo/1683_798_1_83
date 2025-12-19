package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeliveryEvaluation;
import java.util.List;

public interface DeliveryEvaluationRepository extends JpaRepository<DeliveryEvaluation, Long> {

    List<DeliveryEvaluation> findByVendorld(Long vendorld);

    List<DeliveryEvaluation> findBySlaRequirementld(Long slald);
}
