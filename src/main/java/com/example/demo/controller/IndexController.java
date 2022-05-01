package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import com.example.demo.domain.CalcResult;
import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;
import com.example.demo.service.DateCalcService;

@Controller
public class IndexController {
	
	@Autowired
	DateCalcService dateCalcService;
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		List<CalcResult> resultList = dateCalcService.calcResultList;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("standartDate", dateCalcService.standartDate);
		
		return "index";
	}
	
	@PostMapping("/index")
	public String postIndex(@RequestParam("date") String date) {
		
		if(StringUtils.isEmpty(date)){
			return "redirect:/index";
		}
		
		dateCalcService.getDate(date);
		dateCalcService.calcDate(date);
		
		return "redirect:/index";
	}
	
}
