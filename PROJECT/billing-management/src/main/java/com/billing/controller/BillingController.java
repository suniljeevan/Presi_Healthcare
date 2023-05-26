package com.billing.controller;

import com.billing.model.PatientBilling;
import com.billing.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private static final Logger logger = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    private BillingService billingService;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getBill() {
        Object bills = billingService.getBill();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
    
    @GetMapping("/get-by-id/{billId}")
    public ResponseEntity<Object> getBillingById(@PathVariable("billId") Long billId) {
        logger.info("Getting bill details by billId: {}", billId);
        Object billDetailsById = billingService.getBillDetailsById(billId);
        return new ResponseEntity<>(billDetailsById, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveBilling(@RequestBody PatientBilling patientBilling) {
        Object saved = billingService.saveBillDetails(List.of(patientBilling));
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Object> saveBillings(@RequestBody List<PatientBilling> patientBillings) {
        Object saved = billingService.saveBillDetails(patientBillings);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<Object> getBillByName(@PathVariable("name") String name) {
        Object bills = billingService.getBillByName(name);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{billId}")
    public ResponseEntity<Object> deleteBilling(@PathVariable("billId") Long billId) {
        Object result = billingService.deleteById(billId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
