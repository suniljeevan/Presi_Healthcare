package com.billing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient_billing")
public class PatientBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    private String name;
    private String contact;
    private Double appointmentFee;
    private Double medicalExpenses;
    private Double totalExpenses = 0.0;
}
