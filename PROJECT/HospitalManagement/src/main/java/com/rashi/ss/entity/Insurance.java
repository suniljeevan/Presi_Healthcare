package com.rashi.ss.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonView;
import com.rashi.ss.util.Enums.InsuranceTypes;
import com.rashi.ss.view.JsonViews.InsuranceJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Insurance {
	
	@JsonView(InsuranceJsonView.class)
	private String insuranceProvider;
	
	@JsonView(InsuranceJsonView.class)
	@Enumerated(EnumType.STRING)
	private InsuranceTypes insuranceType;
	
	@JsonView(InsuranceJsonView.class)
	private double insuranceSum;

	public void setInsuranceProvider(String insuranceProvider2) {
		// TODO Auto-generated method stub
		
	}

	public void setInsuranceType(InsuranceTypes insuranceType2) {
		// TODO Auto-generated method stub
		
	}

	public void setInsuranceSum(double insuranceSum2) {
		// TODO Auto-generated method stub
		
	}


	
}
