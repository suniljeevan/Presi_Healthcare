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
import com.pres.Pharmacy.model.PharmacyInventory;
import com.pres.Pharmacy.repository.InventoryRepo;







@CrossOrigin("*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    Logger logger = LoggerFactory.getLogger(InventoryController.class);
    
    @Autowired
    private InventoryRepo inventoryRepo;

    @GetMapping("/all")
    public List<PharmacyInventory> getAllStock(){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		
        return inventoryRepo.findAll();
    }

    @PostMapping("/save")
    public PharmacyInventory createInventory(@RequestBody PharmacyInventory pharmacyInventory) {
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
    	
        return inventoryRepo.save(pharmacyInventory);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<PharmacyInventory> getInventoryById(@PathVariable  long id){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
    	
    	PharmacyInventory pharmacyInventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product does not exist with id:" + id));
        return ResponseEntity.ok(pharmacyInventory);
    }

    @PutMapping("/update/by/id/{id}")
    public ResponseEntity<PharmacyInventory> updateInventory(@PathVariable long id,@RequestBody PharmacyInventory inventoryDetails) {
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");
		
    	PharmacyInventory updateInventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product does not exist with id: " + id));

    
    	updateInventory.setProductName(inventoryDetails.getProductName());

    	updateInventory.setQuantity(inventoryDetails.getQuantity());

    	updateInventory.setPrice(inventoryDetails.getPrice());
    	

		inventoryRepo.save(updateInventory);

        return ResponseEntity.ok(updateInventory);
    }

    @DeleteMapping("/delete/by/id/{id}")
    public ResponseEntity<HttpStatus> deleteInventory(@PathVariable long id){
    	
    	logger.info("[getMessage] info message");
		logger.warn("[getMessage] warn message");
		logger.error("[getMessage] error message");
		logger.debug("[getMessage] debug message");
		logger.trace("[getMessage] trace message");

    	PharmacyInventory pharmacyInventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id: " + id));

    	inventoryRepo.delete(pharmacyInventory);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    
}
