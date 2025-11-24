package com.example.MyNotes.repository;
import com.example.MyNotes.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
