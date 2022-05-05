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

import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AddController {
	
	private final DateCalcMapper dateCalcMapper;
	
	@GetMapping("/add")
	public String getAdd(Model model, Pattern pattern) {
		
		model.addAttribute("pattern", new Pattern());
		
		return "add";
	}
	
	@PostMapping("/add")
	public String postAdd(@Validated Pattern pattern,
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error: bindingResult.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "add";
		}
		dateCalcMapper.addPattern(pattern);
		
		return "redirect:/index";
	}
}
