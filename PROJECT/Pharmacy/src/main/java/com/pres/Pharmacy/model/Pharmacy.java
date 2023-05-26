package com.pres.Pharmacy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Pharmacy")

public class Pharmacy {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pharmacyId;
	
    @Column(name="Pharmacy_Name",nullable=false)
	private String pharmacyName;

    @Column(name="Pharmacy_Address",nullable=false)
	private String pharmacyAddress;

    @Column(name="Phone_Number",nullable=false)
	private String pharmacyPhone;




    public Long getId() {
        return pharmacyId;
    }

    public String getpharmacyName() {
        return pharmacyName;
    }

    public void setpharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getpharmacyAddress() {
        return pharmacyAddress;
    }

    public void setpharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getpharmacyPhone() {
        return pharmacyPhone;
    }

    public void setpharmacyPhone(String pharmacyPhone) {
        this.pharmacyPhone = pharmacyPhone;
    }
    
}
