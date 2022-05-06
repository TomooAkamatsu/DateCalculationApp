package com.example.demo.domain;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Pattern {
	
	private int id;
	
	@NotBlank(message = "日付IDを入力してください")
	private String dateId;
	
	@NotBlank(message = "日付名を入力してください")
	private String dateName;
	
	private int calcY;
	
	private int calcM;
	
	private int calcD;

}
