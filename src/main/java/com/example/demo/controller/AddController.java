package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Pattern;
import com.example.demo.repository.DateCalcMapper;

@Controller
public class AddController {
	
	@Autowired
	DateCalcMapper dateCalcMapper;
	
	@GetMapping("/add")
	public String getAdd(Model model) {
		
		model.addAttribute("pattern", new Pattern());
		
		return "add";
	}
	
	@PostMapping("/add")
	public String postAdd(Pattern pattern) {
		
		System.out.println(pattern);
		
		dateCalcMapper.addPattern(pattern);
		
		
		return "redirect:/index";
	}

}
