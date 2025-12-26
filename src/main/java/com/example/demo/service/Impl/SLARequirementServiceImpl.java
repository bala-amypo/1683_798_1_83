// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import com.example.demo.entity.SLARequirement;
// import com.example.demo.repository.SLARequirementRepository;
// import com.example.demo.service.SLARequirementService;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class SLARequirementServiceImpl implements SLARequirementService {

//     private final SLARequirementRepository repository;

//     public SLARequirementServiceImpl(SLARequirementRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public SLARequirement createRequirement(SLARequirement sla) {
//         sla.setActive(true); // default active
//         return repository.save(sla);
//     }

//     @Override
//     public SLARequirement updateRequirement(Long id, SLARequirement sla) {
//         Optional<SLARequirement> existing = repository.findById(id);
//         if(existing.isPresent()) {
//             SLARequirement updated = existing.get();
//             updated.setRequirementName(sla.getRequirementName());
//             updated.setActive(sla.isActive());
//             return repository.save(updated);
//         }
//         return null;
//     }

//     @Override
//     public SLARequirement getRequirementById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
//     public List<SLARequirement> getAllRequirements() {
//         return repository.findAll();
//     }

//     @Override
//     public void deactivateRequirement(Long id) {
//         Optional<SLARequirement> existing = repository.findById(id);
//         if(existing.isPresent()) {
//             SLARequirement sla = existing.get();
//             sla.setActive(false);
//             repository.save(sla);
//         }
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;

public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement createRequirement(SLARequirement req) {
        if (req.getMaxDeliveryDays() == null || req.getMaxDeliveryDays() < 1) {
            throw new IllegalArgumentException("Max delivery days must be > 0");
        }

        if (req.getQualityTarget() < 0 || req.getQualityTarget() > 100) {
            throw new IllegalArgumentException("Quality score must be between 0 and 100");
        }

        if (repository.existsByRequirementName(req.getRequirementName())) {
            throw new IllegalArgumentException("Requirement name must be unique");
        }

        req.setActive(true);
        return repository.save(req);
    }

    @Override
    public SLARequirement updateRequirement(Long id, SLARequirement update) {
        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Requirement not found"));

        if (update.getRequirementName() != null &&
            !update.getRequirementName().equals(existing.getRequirementName()) &&
            repository.existsByRequirementName(update.getRequirementName())) {
            throw new IllegalArgumentException("Requirement name must be unique");
        }

        if (update.getDescription() != null) {
            existing.setDescription(update.getDescription());
        }

        return repository.save(existing);
    }

    @Override
    public void deactivateRequirement(Long id) {
        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));
        existing.setActive(false);
        repository.save(existing);
    }
}
