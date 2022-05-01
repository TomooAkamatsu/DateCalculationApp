package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CalcResult;
import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;

@Service
public class DateCalcService {
	
	@Autowired
	DateCalcMapper dateCalcMapper;
	
	public List<CalcResult> calcResultList = new ArrayList<>();
	
	public List<Pattern> getPattern(){
		List<Pattern> datecalclist = dateCalcMapper.findAll();
		return datecalclist;
	}
	
	
	public void calcDate(String strDate) {
		
		calcResultList.clear();
		
		LocalDate date = convertToLocalDate(strDate, "yyyy-MM-dd");
		
		List<Pattern> patterns = dateCalcMapper.findAll();

		
		for (Pattern pattern : patterns) {
			LocalDate dateCalculated = date.plusYears(pattern.getCalcY()).plusMonths(pattern.getCalcM()).plusDays(pattern.getCalcD());
			
			String strDateCalculated = dateCalculated.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			
			CalcResult calcResult = new CalcResult(
					pattern.getNumber(),
					pattern.getDateId(),
					pattern.getDateName(),
					strDateCalculated,
					pattern.getCalcY() + "/" + pattern.getCalcM() + "/" + pattern.getCalcD()
					);
			
			calcResultList.add(calcResult);
			
		}

	}
	
	public String standartDate;
	
	public void getDate(String strDate) {
		
		LocalDate date = convertToLocalDate(strDate, "yyyy-MM-dd");
		
		this.standartDate = date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
	}


	public static LocalDate convertToLocalDate(String date, String format) {
		// LocalDate型に変換された日付を返却
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
	}
	

}
