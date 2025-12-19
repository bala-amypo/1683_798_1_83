package com.example.demo.service.impl;

import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor createVendor(Vendor vendor) {
        if (vendorRepository.existsByName(vendor.getName())) {
            throw new IllegalArgumentException("unique");
        }
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorByld(id);
        existing.setName(vendor.getName());
        existing.setContactEmail(vendor.getContactEmail());
        existing.setContactPhone(vendor.getContactPhone());
        return vendorRepository.save(existing);
    }

    public Vendor getVendorByld(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public void deactivateVendor(Long id) {
        Vendor vendor = getVendorByld(id);
        vendor.setActive(false);
        vendorRepository.save(vendor);
    }
}
