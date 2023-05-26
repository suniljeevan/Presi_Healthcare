package com.billing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient_billing")
public class PatientBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private Long appointmentId;
    private String name;
    private String contact;
    private Double appointmentFee;
  
	public Double getAppointmentFee() {
		// TODO Auto-generated method stub
		return appointmentFee;
	}
	public void setTotalExpenses(double d) {
		// TODO Auto-generated method stub
		
	}
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
}
