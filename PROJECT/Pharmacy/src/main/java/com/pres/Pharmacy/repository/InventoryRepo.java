package com.pres.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pres.Pharmacy.model.PharmacyInventory;

public interface InventoryRepo extends JpaRepository<PharmacyInventory, Long>{
    
}
