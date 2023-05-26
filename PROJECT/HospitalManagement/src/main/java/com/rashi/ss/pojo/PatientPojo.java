package com.rashi.ss.pojo;

import com.rashi.ss.util.Enums.InsuranceTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientPojo {

	private String patientName;
	private String insuranceProvider;
	private InsuranceTypes insuranceType;
	private double insuranceSum;
	public Object getPatientName() {
		// TODO Auto-generated method stub
		return patientName;
	}
	public String getInsuranceProvider() {
		return insuranceProvider;
	}
	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}
	public InsuranceTypes getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(InsuranceTypes insuranceType) {
		this.insuranceType = insuranceType;
	}
	public double getInsuranceSum() {
		return insuranceSum;
	}
	public void setInsuranceSum(double insuranceSum) {
		this.insuranceSum = insuranceSum;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}
