package com.rashi.ss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.rashi.ss.util.Enums.DoctorDepartments;
import com.rashi.ss.util.Enums.DoctorQualifications;
import com.rashi.ss.view.JsonViews.CommonJsonView;
import com.rashi.ss.view.JsonViews.DoctorJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;

	public Long getId() {
        return doctorId;
    }

    public void setId(Long id) {
        this.doctorId = id;
    }
	
	@JsonView(CommonJsonView.class)
	private String doctorName;
	
	@JsonView(CommonJsonView.class)
	@Enumerated(EnumType.STRING)
	private DoctorDepartments doctorDepartment;
	
	@JsonView(CommonJsonView.class)
	@Enumerated(EnumType.STRING)
	private DoctorQualifications doctorQualification;

	@OneToMany(mappedBy = "doctor")
	@JsonView(DoctorJsonView.class)
	private List<Appointment> appointments;
	
	@ManyToMany(mappedBy = "doctors")
	@JsonView(DoctorJsonView.class)
	private List<Patient> patients;
	
	public void setAppointment(Appointment appointment) {
		if(appointments!=null) {
			appointment.setDoctor(this);
			appointments.add(appointment);
			return;
		}
		appointments=new ArrayList<>();
		appointment.setDoctor(this);
		appointments.add(appointment);
	}
	
	public void setPatient(Patient patient) {
		if(patients!=null) {
			patients.add(patient);
			return;
		}
		patients=new ArrayList<>();
		patients.add(patient);
	}


	public void setDoctorName(Object doctorName2) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctorDepartment(DoctorDepartments doctorDepartment2) {
		// TODO Auto-generated method stub
		
	}

	public void setDoctorQualification(DoctorQualifications doctorQualification2) {
		// TODO Auto-generated method stub
		
	}

	public String getDoctorName() {
		// TODO Auto-generated method stub
		return doctorName;
	}
	
	
	/*public void setAppointment(Appointment appointment) {
		if(appointments!=null) {
			appointment.setDoctor(this);
			appointments.add(appointment);
			return;
		}
		appointments=new ArrayList<>();
		appointment.setDoctor(this);
		appointments.add(appointment);
	}*/
	

	
}
