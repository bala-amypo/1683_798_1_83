@Override
public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
    return repo.findByVendor_Id(vendorId);
}

@Override
public List<DeliveryEvaluation> getEvaluationsForRequirement(Long slaRequirementId) {
    return repo.findBySlaRequirement_Id(slaRequirementId);
}
