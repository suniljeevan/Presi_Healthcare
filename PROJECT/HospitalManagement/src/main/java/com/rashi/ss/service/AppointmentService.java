package com.rashi.ss.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashi.ss.entity.Appointment;
import com.rashi.ss.entity.Doctor;
import com.rashi.ss.entity.Insurance;
import com.rashi.ss.entity.Patient;
import com.rashi.ss.exception.ResourceNotFoundException;
import com.rashi.ss.pojo.AppointmentPojo;
import com.rashi.ss.repository.AppointmentRepository;
import com.rashi.ss.repository.DoctorRepository;
import com.rashi.ss.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class AppointmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentService.class);

	@Autowired
	private AppointmentRepository appointmentRepo;

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	public void saveAppointment(AppointmentPojo appointmentPojo) {
		LOGGER.info("Logging Services started appointment services");
		
	
		Appointment appointment = new Appointment();
		Date date = Date.valueOf(appointmentPojo.getAppointmentDate());
		appointment.setAppointmentDate(date);
		Time time = Time.valueOf(appointmentPojo.getAppointmentTime());
		appointment.setAppointmentTime(time);
		Doctor doctor = doctorRepo.findByDoctorName(appointmentPojo.getDoctorName());
		appointment.setDoctor(doctor);
		Patient patient = patientRepo.findByPatientName(appointmentPojo.getPatientName());
		appointment.setPatient(patient);
		appointmentRepo.save(appointment);
	}
	
	public List<Appointment> fetchAllAppointments() {
		LOGGER.info("-----Logging Services started appointment services-----"); 
		
		return appointmentRepo.findAll();
	}
	
	public Appointment fetchAppointmentById(Long id) {
		

		List<Appointment> appointments = fetchAllAppointments();
        Optional<Appointment> appointment = appointments.stream().filter(a -> a.getId() == id).findFirst();
        if (appointment.isPresent()) {
            return appointment.get();
        } else {
            LOGGER.error("Appointment not found with ID : {}", id);
            throw new ResourceNotFoundException("Appointment not found with ID : " + id);
        }
		
	}
	
	public List<Appointment> fetchAppointmentsByDate(String date) {
		return appointmentRepo.findAppointmentsByDate(Date.valueOf(date));
	}
	
	public List<Appointment> fetchAppointmentsByTime(String time) {
		return appointmentRepo.findAppointmentsByTime(Time.valueOf(time));
	}
	
	public List<Appointment> fetchAppointmentsByDateTime(String date, String time) {
		return appointmentRepo.findAppointmentsByDateTime(Date.valueOf("2023-03-16"), Time.valueOf("13:30:00"));
	}
	
	public List<Appointment> fetchAppointmentsByPatientId(Long id) {
		
		LOGGER.info("Logging Services started appointment services");
		return appointmentRepo.findAppointmentsByPatientId(id);
	}
	
	public List<Appointment> fetchAppointmentsByDoctorId(Long id) {
		LOGGER.info("Logging Services started appointment services");
		return appointmentRepo.findAppointmentsByDoctorId(id);
	}
}
