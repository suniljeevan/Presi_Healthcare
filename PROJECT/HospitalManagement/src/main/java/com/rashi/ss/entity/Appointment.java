package com.rashi.ss.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashi.ss.view.JsonViews.AppointmentJsonView;
import com.rashi.ss.view.JsonViews.CommonJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;

	public Long getId() {
        return appointmentId;
    }

    public void setId(Long id) {
        this.appointmentId = id;
    }

	@JsonView(CommonJsonView.class)
	private Date appointmentDate;
	
	@JsonView(CommonJsonView.class)
	private Time appointmentTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id", referencedColumnName = "patientId")
	@JsonView(AppointmentJsonView.class)
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_id", referencedColumnName = "doctorId")
	@JsonView(AppointmentJsonView.class)
	private Doctor doctor;

	
	public void setAppointmentDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setAppointmentTime(Time time) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctor(Doctor doctor2) {
		// TODO Auto-generated method stub
		
	}

	public void setPatient(Patient patient2) {
		// TODO Auto-generated method stub
		
	}

	
}
