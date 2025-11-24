package com.example.MyNotes.controller;
import com.example.MyNotes.model.Tenant;
import com.example.MyNotes.repository.TenantRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    private final TenantRepository TenantRepository;
    public TenantController(TenantRepository tenantRepository) {
        this.TenantRepository = tenantRepository;
    }
    // Create a new tenant
    @PostMapping
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return TenantRepository.save(tenant);
    }
    // Get all tenants
    @GetMapping
    public List<Tenant> getAllTenants() {
        return TenantRepository.findAll();
    }
    // Get tenant by ID
    @GetMapping("/{id}")
    public Tenant getTenantById(@PathVariable Long id) {
        return TenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id: " + id));
    }
}

