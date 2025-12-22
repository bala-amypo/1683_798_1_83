package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.VendorService;
import com.example.demo.entity.Vendor;
import com.example.demo.repository.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service  // THIS MAKES IT A SPRING BEAN
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        vendor.setActive(true);
        return repository.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Optional<Vendor> existing = repository.findById(id);
        if(existing.isPresent()) {
            Vendor v = existing.get();
            v.setName(vendor.getName());
            v.setActive(vendor.isActive());
            return repository.save(v);
        }
        return null;
    }

    @Override
    public void deactivateVendor(Long id) {
        Optional<Vendor> existing = repository.findById(id);
        if(existing.isPresent()) {
            Vendor v = existing.get();
            v.setActive(false);
            repository.save(v);
        }
    }
}
