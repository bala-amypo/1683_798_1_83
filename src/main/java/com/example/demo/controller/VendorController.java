// package com.example.demo.controller;

// import com.example.demo.model.Vendor;
// import com.example.demo.service.VendorService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// import java.util.List;

// @RestController
// @RequestMapping("/api/vendors")
// @SecurityRequirement(name="bearerAuth")
// public class VendorController {

//     private final VendorService vendorService;

//     public VendorController(VendorService vendorService) {
//         this.vendorService = vendorService;
//     }

//     @PostMapping
//     public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
//         return ResponseEntity.ok(vendorService.createVendor(vendor));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Vendor> updateVendor(@PathVariable Long id,
//                                                @RequestBody Vendor vendor) {
//         return ResponseEntity.ok(vendorService.updateVendor(id, vendor));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
//         return ResponseEntity.ok(vendorService.getVendorById(id));
//     }

//     @GetMapping
//     public ResponseEntity<List<Vendor>> getAllVendors() {
//         return ResponseEntity.ok(vendorService.getAllVendors());
//     }

//     @PutMapping("/{id}/deactivate")
//     public ResponseEntity<Void> deactivateVendor(@PathVariable Long id) {
//         vendorService.deactivateVendor(id);
//         return ResponseEntity.ok().build();
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id,
                               @RequestBody Vendor vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateVendor(@PathVariable Long id) {
        vendorService.deactivateVendor(id);
    }
}



