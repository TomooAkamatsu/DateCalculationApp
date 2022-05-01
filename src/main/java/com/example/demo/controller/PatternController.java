package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;
import com.example.demo.service.DateCalcService;

@Controller
public class PatternController {
	
	@Autowired
	DateCalcService dateCalcService;
	
	@Autowired
	DateCalcMapper dateCalcMapper;
	
	@GetMapping("/pattern")
	public String getPattern(Model model) {
		
		List<Pattern> patternList = dateCalcService.getPattern();
		
		model.addAttribute("pattern", patternList);
		
		return "pattern";
	}
	
	@PostMapping(value="/pattern", params = "update")
	public String postUpdatePattern(Pattern pattern) {
		System.out.println(pattern);
		
		dateCalcMapper.updatePattern(pattern);
		
		return "redirect:/pattern";
	}
	
	@PostMapping(value="/pattern", params = "delete")
	public String postDeletePattern(@RequestParam("delete") String strNumber) {
		
		int number = Integer.parseInt(strNumber);	
		
		dateCalcMapper.deletePattern(number);
		
		return "redirect:/pattern";
	}
	

}
