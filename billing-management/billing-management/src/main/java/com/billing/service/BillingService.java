package com.billing.service;

import com.billing.model.PatientBilling;

import java.util.List;

public interface BillingService {

    Object getBillDetailsById(int billId);

    Object saveBillDetails(List<PatientBilling> patientBillings);

    Object getBillByName(String name);

    Object deleteById(int billId);
}
