package com.billing.dao;

import com.billing.model.PatientBilling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingDao extends JpaRepository<PatientBilling, Integer> {

    List<PatientBilling> findByNameIgnoreCase(String name);
}
