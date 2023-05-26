package com.rashi.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashi.ss.entity.Appointment;
import com.rashi.ss.pojo.AppointmentPojo;
import com.rashi.ss.service.AppointmentService;
import com.rashi.ss.view.JsonViews.AppointmentJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);


	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/save")
	public void saveAppointment(AppointmentPojo appointmentPojo) {
		LOGGER.info("----Logging Services started appointment controller-----");
		LOGGER.warn("[getMessage] warn message");
		LOGGER.error("[getMessage] error message");
		LOGGER.debug("[getMessage] debug message");
		LOGGER.trace("[getMessage] trace message");
		appointmentService.saveAppointment(appointmentPojo);
	}
	
	
	@GetMapping("/find/all")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAllAppointments() {
		LOGGER.info("----fetching all appointment details-----");
		LOGGER.warn("warn message -- fetching all appointment");
		LOGGER.error("error message -- fetching all appointment");
		LOGGER.debug("debug message -- fetching all appointment");
		LOGGER.trace("trace message -- fetching all appointment");
		
		
		return appointmentService.fetchAllAppointments();
	}
	
	@GetMapping("/find/{id}")
	@JsonView(AppointmentJsonView.class)
	public Appointment fetchAppointmentById(@PathVariable("id") Long id) {
		LOGGER.info("----fetching all appointment details by appointment id-----");
		LOGGER.warn("warn message -- fetching  appointment by id");
		LOGGER.error("error message -- fetching  appointment by id");
		LOGGER.debug("debug message -- fetching  appointment by id");
		LOGGER.trace("trace message -- fetching  appointment by id");
	    
		return appointmentService.fetchAppointmentById(id);	
	}
		
	
	
	
	@GetMapping("/find/by/date/{date}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDate(@PathVariable("date") String date) {
		LOGGER.info("-----fetching all appointment details by appointment date-----");
		LOGGER.warn("warn message -- fetching  appointment by date");
		LOGGER.error("error message -- fetching  appointment by date");
		LOGGER.debug("debug message -- fetching  appointment by date");
		LOGGER.trace("trace message -- fetching  appointment by date");
		return appointmentService.fetchAppointmentsByDate(date);
	}
	
	@GetMapping("/find/by/time/{time}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByTime(@PathVariable("time") String time) {
		LOGGER.info("------fetching all appointment details by appointment time-----");
		LOGGER.warn("warn message -- fetching  appointment by time");
		LOGGER.error("error message -- fetching  appointment by time");
		LOGGER.debug("debug message -- fetching  appointment by time");
		LOGGER.trace("trace message -- fetching  appointment by time");
		return appointmentService.fetchAppointmentsByTime(time);
	}
	
	@GetMapping("/find/by/datetime/{date}/{time}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDateTime(@PathVariable("date") String date, @PathVariable("time") String time) {
		LOGGER.info("------fetching all appointment details by appointment date and time-----");
		LOGGER.warn("warn message -- fetching  appointment by date and time");
		LOGGER.error("error message -- fetching  appointment by date and time");
		LOGGER.debug("debug message -- fetching  appointment by date and time");
		LOGGER.trace("trace message -- fetching  appointment by date and time");
		return appointmentService.fetchAppointmentsByDateTime(date, time);
	}
	
	@GetMapping("/find/by/patient/{id}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByPatientId(@PathVariable("id") Long id) {
		LOGGER.info("----fetching all appointment details by patient id-----");
		LOGGER.warn("warn message -- fetching  appointment by patient id");
		LOGGER.error("error message -- fetching  appointment by patient id");
		LOGGER.debug("debug message -- fetching  appointment by patient id");
		LOGGER.trace("trace message -- fetching  appointment by patient id");
		return appointmentService.fetchAppointmentsByPatientId(id);
	}
	
	@GetMapping("/find/by/doctor/{id}")
	@JsonView(AppointmentJsonView.class)
	public List<Appointment> fetchAppointmentsByDoctorId(@PathVariable("id") Long id) {
		LOGGER.info("-----fetching all appointment details by doctor id------");
		LOGGER.warn("warn message -- fetching  appointment by doctor id");
		LOGGER.error("error message -- fetching  appointment by doctor id");
		LOGGER.debug("debug message -- fetching  appointment by doctor id");
		LOGGER.trace("trace message -- fetching  appointment by doctor id");
		return appointmentService.fetchAppointmentsByDoctorId(id);
	}
}
