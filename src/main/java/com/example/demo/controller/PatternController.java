package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;
import com.example.demo.service.DateCalcService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PatternController {
	

	private final DateCalcService dateCalcService;
	
	private final DateCalcMapper dateCalcMapper;
	
	@GetMapping("/pattern")
	public String getPattern(Model model) {
		
		List<Pattern> patternList = dateCalcService.getPattern();
		
		model.addAttribute("pattern", patternList);
		
		return "pattern";
	}
	
	@PostMapping(value="/pattern", params = "update")
	public String postUpdatePattern(@Validated Pattern pattern,
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error: bindingResult.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return getPattern(model);
		}
		
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
