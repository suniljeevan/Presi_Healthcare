package com.billing.service;

import com.billing.model.PatientBilling;

import java.util.List;

public interface BillingService {

    Object getBillDetailsById(Long billId);

    Object saveBillDetails(List<PatientBilling> patientBillings);

    Object getBillByName(String name);

    Object deleteById(Long billId);

	Object getBill();

}
