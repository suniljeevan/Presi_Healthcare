package com.rashi.ss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashi.ss.entity.Doctor;
import com.rashi.ss.pojo.DoctorPojo;
import com.rashi.ss.repository.DoctorRepository;
import com.rashi.ss.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DoctorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);

	@Autowired
	private DoctorRepository doctorRepo;

	public List<Doctor> fetchAllDoctors() {
		
		return doctorRepo.findAll();
	}

	public String fetchDoctorById(Long id) {

		List<Doctor> doctors = fetchAllDoctors();
        Optional<Doctor> doctor = doctors.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (doctor.isPresent()) {
            return doctor.get().getDoctorName();
        } else {
            LOGGER.error("doctor not found with ID : {}", id);
            throw new ResourceNotFoundException("doctor not found with ID : " + id);
        }
		//Doctor findById = doctorRepo.findById(id).get();
		//return findById.getDoctorName();
	}

	public List<Doctor> fetchDoctorsByName(String name) {
		return doctorRepo.findDoctorsByName(name);
	}

	public List<Doctor> fetchDoctorsByQualification(String qualification) {
		return doctorRepo.findDoctorsByQualification(qualification);
	}

	public List<Doctor> fetchDoctorsByDepartment(String department) {
		return doctorRepo.findDoctorsByDepartment(department);
	}

	public void saveDoctor(DoctorPojo doctorPojo) {
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorPojo.getDoctorName());
		doctor.setDoctorDepartment(doctorPojo.getDoctorDepartment());
		doctor.setDoctorQualification(doctorPojo.getDoctorQualification());
		doctorRepo.save(doctor);
	}
}
