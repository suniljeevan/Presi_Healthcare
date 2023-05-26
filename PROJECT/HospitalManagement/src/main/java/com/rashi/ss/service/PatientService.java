package com.rashi.ss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashi.ss.entity.Insurance;
import com.rashi.ss.entity.Patient;
import com.rashi.ss.pojo.PatientPojo;
import com.rashi.ss.repository.PatientRepository;
import com.rashi.ss.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PatientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepository patientRepo;

	public void savePatient(PatientPojo patientPojo) {
		Patient patient = new Patient();
		patient.setPatientName(patientPojo.getPatientName());
		Insurance insurance = new Insurance();
		insurance.setInsuranceProvider(patientPojo.getInsuranceProvider());
		insurance.setInsuranceSum(patientPojo.getInsuranceSum());
		insurance.setInsuranceType(patientPojo.getInsuranceType());
		patient.setInsurance(insurance);
		patientRepo.save(patient);
	}

	public List<Patient> fetchAllPatients() {
		return patientRepo.findAll();
	}
	
	public String fetchPatientById(Long id) {

		List<Patient> patients = fetchAllPatients();
        Optional<Patient> patient = patients.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (patient.isPresent()) {
            return patient.get().getPatientName();
        } else {
            LOGGER.error("doctor not found with ID : {}", id);
            throw new ResourceNotFoundException("doctor not found with ID : " + id);
        }
		//Patient findById = patientRepo.findById(id).get();
		//return findById.getPatientName();
	}
	
	public List<Patient> fetchPatientsByName(String name) {
		return patientRepo.findPatientsByName(name);
	}
	
	public List<Patient> fetchPatientsByInsuranceProvider(String provider) {
		return patientRepo.findPatientsByInsuranceProvider(provider);
	}
	
	public List<Patient> fetchPatientsByInsuranceType(String type) {
		return patientRepo.findPatientsByInsuranceType(type);
	}

}
