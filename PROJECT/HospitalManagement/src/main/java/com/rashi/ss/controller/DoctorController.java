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
import com.rashi.ss.entity.Doctor;
import com.rashi.ss.pojo.DoctorPojo;
import com.rashi.ss.service.DoctorService;
import com.rashi.ss.view.JsonViews.CommonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/save")
	public void saveDoctor(@RequestBody DoctorPojo doctorPojo) {

		LOGGER.info("Logging Services started doctor controller");
		LOGGER.info("[getMessage] info message");
		LOGGER.warn("[getMessage] warn message");
		LOGGER.error("[getMessage] error message");
		LOGGER.debug("[getMessage] debug message");
		LOGGER.trace("[getMessage] trace message");
		
		doctorService.saveDoctor(doctorPojo);
	}
	
	@GetMapping("/find/all")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchAllDoctors() {
		LOGGER.info("----fetching all doctors----");
		LOGGER.warn("warn message -- fetching all doctors");
		LOGGER.error("error message -- fetching all doctors");
		LOGGER.debug("debug message -- fetching all doctors");
		LOGGER.trace("trace message -- fetching all doctors");
		
		return doctorService.fetchAllDoctors();
	}
	
	@GetMapping("/find/{id}")
	@JsonView(CommonJsonView.class)
	public String fetchDoctorById(@PathVariable("id") Long id) {
		LOGGER.info("------fetching doctors by id------");
		
		LOGGER.warn("warn message -- fetching doctor by id");
		LOGGER.error("error message -- fetching doctor by id");
		LOGGER.debug("debug message -- fetching doctor by id");
		LOGGER.trace("trace message -- fetching doctor by id");
		
		return doctorService.fetchDoctorById(id);
	}
	
	@GetMapping("/find/name/{name}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByName(@PathVariable("name") String name) {
		LOGGER.info("------fetching doctors by name------");
		LOGGER.warn("warn message -- fetching doctor by name");
		LOGGER.error("error message -- fetching doctor by name");
		LOGGER.debug("debug message -- fetching doctor by name");
		LOGGER.trace("trace message -- fetching doctor by name");
		
		return doctorService.fetchDoctorsByName(name);
	}
	
	@GetMapping("/find/qualification/{qualification}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByQualification(@PathVariable("qualification")String qualification) {
		LOGGER.info("------fetching doctors by qualification-----");
		LOGGER.warn("warn message -- fetching doctor by qualification");
		LOGGER.error("error message -- fetching doctor by qualification");
		LOGGER.debug("debug message -- fetching doctor by qualification");
		LOGGER.trace("trace message -- fetching doctor by qualification");
		
		return doctorService.fetchDoctorsByQualification(qualification);
	}
	
	@GetMapping("/find/department/{department}")
	@JsonView(CommonJsonView.class)
	public List<Doctor> fetchDoctorsByDepartment(@PathVariable("department") String department) {
		LOGGER.info("----fetching doctors by department-----");
		LOGGER.warn("warn message -- fetching doctor by department");
		LOGGER.error("error message -- fetching doctor by department");
		LOGGER.debug("debug message -- fetching doctor by department");
		LOGGER.trace("trace message -- fetching doctor by department");
		
		
		return doctorService.fetchDoctorsByDepartment(department);
	}
	
	
}
