package com.rashi.ss.pojo;

import com.rashi.ss.util.Enums.DoctorDepartments;
import com.rashi.ss.util.Enums.DoctorQualifications;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorPojo {

	private String doctorName;
	private DoctorDepartments doctorDepartment;
	private DoctorQualifications doctorQualification;
	
	
	public DoctorDepartments getDoctorDepartment() {
		return doctorDepartment;
	}
	public void setDoctorDepartment(DoctorDepartments doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}
	public DoctorQualifications getDoctorQualification() {
		return doctorQualification;
	}
	public void setDoctorQualification(DoctorQualifications doctorQualification) {
		this.doctorQualification = doctorQualification;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Object getDoctorName() {
		// TODO Auto-generated method stub
		return doctorName;
	}
	
	
	
}
