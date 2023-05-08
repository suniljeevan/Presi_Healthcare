package com.billing.service;

import com.billing.dao.BillingDao;
import com.billing.model.PatientBilling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    private static final Logger logger = LoggerFactory.getLogger(BillingServiceImpl.class);

    /*Dao: Data Access Object*/
    @Autowired
    private BillingDao billingDao;

    @Override
    public Object getBillDetailsById(int billId) {
        return billingDao.findById(billId);
    }

    @Override
    public Object saveBillDetails(List<PatientBilling> patientBillings) {
        for (PatientBilling patientBilling : patientBillings) {
            if (patientBilling.getTotalExpenses() <= 0) {
                patientBilling.setTotalExpenses(patientBilling.getMedicalExpenses() + patientBilling.getAppointmentFee());
            }
        }
        try {
            logger.debug("save bill details with saveBillDetails: {}", patientBillings);
            return billingDao.saveAll(patientBillings);
        } catch (Exception e) {
            logger.error("Exception while deleting the bill details.", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getBillByName(String name) {
        try {
            List<PatientBilling> patientBillings = billingDao.findByNameIgnoreCase(name);
            if (patientBillings == null || patientBillings.size() == 0) {
                return "No results found";
            }
            return patientBillings;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occurred: {}", e.getMessage());
            return "Unable to process request";
        }
    }

    @Override
    public Object deleteById(int billId) {
        try {
            logger.debug("Deleting bill details with billId: {}", billId);
            billingDao.deleteById(billId);
        } catch (Exception e) {
            logger.error("Exception while deleting the bill details.", e);
            throw new RuntimeException(e);
        }
        return "Deleted billing details by billId " + billId;
    }
}
