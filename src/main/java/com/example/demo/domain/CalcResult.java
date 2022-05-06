package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalcResult {

	private int id;

	private String dateId;

	private String dateName;

	private String dateCalculated;

	private String calcParam;

}
