package com.pres.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pres.Pharmacy.model.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy , Long>{

    /*public Pharmacy save(Pharmacy pharmacy) {
        return null;
    }

    public List<Pharmacy> findAll() {
        return null;
    }

    public Object findById(long id) {
        return null;
    }

    public void delete(Pharmacy pharmacy) {
    }*/
    
}
