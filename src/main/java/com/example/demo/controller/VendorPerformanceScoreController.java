// package com.example.demo.controller;

// import com.example.demo.model.VendorPerformanceScore;
// import com.example.demo.service.VendorPerformanceScoreService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// import java.util.List;

// @RestController
// @RequestMapping("/api/scores")
// @SecurityRequirement(name="bearerAuth")
// public class VendorPerformanceScoreController {

//     private final VendorPerformanceScoreService scoreService;

//     public VendorPerformanceScoreController(
//             VendorPerformanceScoreService scoreService) {
//         this.scoreService = scoreService;
//     }

//     @PostMapping("/calculate/{vendorId}")
//     public ResponseEntity<VendorPerformanceScore>
//     calculate(@PathVariable Long vendorId) {
//         return ResponseEntity.ok(
//                 scoreService.calculateScore(vendorId)
//         );
//     }

//     @GetMapping("/latest/{vendorId}")
//     public ResponseEntity<VendorPerformanceScore>
//     latest(@PathVariable Long vendorId) {
//         return ResponseEntity.ok(
//                 scoreService.getLatestScore(vendorId)
//         );
//     }

//     @GetMapping("/vendor/{vendorId}")
//     public ResponseEntity<List<VendorPerformanceScore>>
//     history(@PathVariable Long vendorId) {
//         return ResponseEntity.ok(
//                 scoreService.getScoresForVendor(vendorId)
//         );
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance-scores")
public class VendorPerformanceScoreController {

    private final VendorPerformanceScoreService scoreService;

    public VendorPerformanceScoreController(VendorPerformanceScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/{vendorId}")
    public VendorPerformanceScore calculate(@PathVariable Long vendorId) {
        return scoreService.calculateScore(vendorId);
    }

    @GetMapping("/{vendorId}/latest")
    public VendorPerformanceScore getLatest(@PathVariable Long vendorId) {
        return scoreService.getLatestScore(vendorId);
    }

    @GetMapping("/{vendorId}")
    public List<VendorPerformanceScore> getHistory(@PathVariable Long vendorId) {
        return scoreService.getScoresForVendor(vendorId);
    }
}
