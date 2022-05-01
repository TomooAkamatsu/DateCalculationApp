package com.example.demo.domain;

import lombok.Data;

@Data
public class CalcResult {
	
	private int number;
	
	private String dateId;
	
	private String dateName;
	
	private String dateCalculated;
	
	private String calcParam;
	
	public CalcResult(int number, String dateId, String dateName, String dateCalculated, String calcParam) {
		this.number = number;
		this.dateId = dateId;
		this.dateName = dateName;
		this.dateCalculated = dateCalculated;
		this.calcParam = calcParam;
		
	}
	
}
