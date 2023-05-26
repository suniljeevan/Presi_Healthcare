package com.rashi.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashi.ss.entity.Patient;
import com.rashi.ss.pojo.PatientPojo;
import com.rashi.ss.service.PatientService;
import com.rashi.ss.view.JsonViews.CommonJsonView;
import com.rashi.ss.view.JsonViews.InsuranceJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@PostMapping("/save")
	public void savePatient(@RequestBody PatientPojo patientPojo) {
		LOGGER.info("------Logging Services started patient controller------");
		LOGGER.warn("[getMessage] warn message");
		LOGGER.error("[getMessage] error message");
		LOGGER.debug("[getMessage] debug message");
		LOGGER.trace("[getMessage] trace message");
		
		
		patientService.savePatient(patientPojo);
	}

	@JsonView(CommonJsonView.class)
	@GetMapping("/find/all")
	public List<Patient> fetchAllPatients() {
		LOGGER.info("-----fetching all patients info------");
		LOGGER.warn("warn message -- fetching all patients");
		LOGGER.error("error message -- fetching all patients");
		LOGGER.debug("debug message -- fetching all patients");
		LOGGER.trace("trace message -- fetching all patients");
		
		return patientService.fetchAllPatients();
	}
	
	@JsonView(CommonJsonView.class)
	@GetMapping("/find/{id}")
	public String fetchPatientById(@PathVariable("id") Long id) {
		LOGGER.info("-----fetching patients info by id------");
		LOGGER.warn("warn message -- fetching patient by id");
		LOGGER.error("error message -- fetching patient by id");
		LOGGER.debug("debug message -- fetching patient by id");
		LOGGER.trace("trace message -- fetching patient by id");
		return patientService.fetchPatientById(id);
	}
	
	@JsonView(CommonJsonView.class)
	@GetMapping("/find/name/{name}")
	public List<Patient> fetchPatientsByName(@PathVariable("name") String name) {
		LOGGER.info("-----fetching patients info by name-----");
		LOGGER.warn("warn message -- fetching patient by name");
		LOGGER.error("error message -- fetching patient by name");
		LOGGER.debug("debug message -- fetching patient by name");
		LOGGER.trace("trace message -- fetching patient by name");
		
		
		return patientService.fetchPatientsByName(name);
	}
	
	@JsonView(InsuranceJsonView.class)
	@GetMapping("/find/by/insurance/provider/{provider}")
	public List<Patient> fetchPatientsByInsuranceProvider(@PathVariable("provider") String provider) {
		LOGGER.info("-----fetching patients info by insurance provider-----");
		LOGGER.warn("warn message -- fetching patient by insurance provider");
		LOGGER.error("error message -- fetching patient by insurance provider");
		LOGGER.debug("debug message -- fetching patient by insurance provider");
		LOGGER.trace("trace message -- fetching patient by insurance provider");
		
		return patientService.fetchPatientsByInsuranceProvider(provider);
	}
	
	@JsonView(InsuranceJsonView.class)
	@GetMapping("/find/by/insurance/type/{type}")
	public List<Patient> fetchPatientsByInsuranceType(@PathVariable("type") String type) {
		LOGGER.info("------fetching patients info by insurance type-----");
		LOGGER.warn("warn message -- fetching patient by insurance type");
		LOGGER.error("error message -- fetching patient by insurance type");
		LOGGER.debug("debug message -- fetching patient by insurance type");
		LOGGER.trace("trace message -- fetching patient by insurance type");
		
		return patientService.fetchPatientsByInsuranceType(type);
	}
}
