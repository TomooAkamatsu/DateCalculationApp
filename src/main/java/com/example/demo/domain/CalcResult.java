package com.example.demo.domain;

import lombok.Data;

@Data
public class CalcResult {

	private final int id;

	private final String dateId;

	private final String dateName;

	private final String dateCalculated;

	private final String calcParam;

}
