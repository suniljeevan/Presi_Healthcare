package com.pres.Pharmacy.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pres.Pharmacy.Exception.ResourceNotFoundException;
import com.pres.Pharmacy.model.Pharmacy;
import com.pres.Pharmacy.repository.PharmacyRepo;


@CrossOrigin("*")
@RestController
@RequestMapping("/Pharmacy")
public class PharmacyController{

    Logger logger = LoggerFactory.getLogger(PharmacyController.class);


    @Autowired
    private PharmacyRepo pharmacyRepo;

    @GetMapping("/all")
    public List<Pharmacy> getAll(){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		
        return pharmacyRepo.findAll();
    }

    @PostMapping("/save")
    public Pharmacy createPharmacy(@RequestBody Pharmacy pharmacy) {
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
    	
        return pharmacyRepo.save(pharmacy);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable  long id){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
    	
    	Pharmacy pharmacy = pharmacyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not exist with id:" + id));
        return ResponseEntity.ok(pharmacy);
    }

    @PutMapping("/update/by/id/{id}")
    public ResponseEntity<Pharmacy> updatePharmacy(@PathVariable long id,@RequestBody Pharmacy pharmacyDetails) {
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		
    	Pharmacy updatePharmacy = pharmacyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy does not exist with id: " + id));

    
    	updatePharmacy.setpharmacyName(pharmacyDetails.getpharmacyName());

    	updatePharmacy.setpharmacyAddress(pharmacyDetails.getpharmacyAddress());

    	updatePharmacy.setpharmacyPhone(pharmacyDetails.getpharmacyPhone());
    	

		pharmacyRepo.save(updatePharmacy);

        return ResponseEntity.ok(updatePharmacy);
    }

    @DeleteMapping("/delete/by/id/{id}")
    public ResponseEntity<HttpStatus> deletePharmacy(@PathVariable long id){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");

    	Pharmacy pharmacy = pharmacyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not exist with id: " + id));

    	pharmacyRepo.delete(pharmacy);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    
}