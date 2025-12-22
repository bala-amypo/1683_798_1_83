package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Vendor;
import com.example.demo.service.VendorService;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @PostMapping
    public Vendor create(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    @GetMapping
    public List<Vendor> getAll() {
        return service.getAllVendors();
    }

    @PutMapping("/{id}")
    public Vendor update(@PathVariable Long id, @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVendor(id);
    }
}
