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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Pattern;
import com.example.demo.service.DateCalcService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/date-calculation/edit")
@RequiredArgsConstructor
@Controller
public class EditController {
	

	private final DateCalcService dateCalcService;
	
	@GetMapping
	public String getPattern(Model model) {
		
		List<Pattern> patternList = dateCalcService.getCalcPattern();
		
		model.addAttribute("pattern", patternList);
		
		return "edit";
	}
	
	@PostMapping(params = "update")
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
		
		dateCalcService.updatePattern(pattern);
		
		return "redirect:/date-calculation/edit";
	}
	
	@PostMapping(params = "delete")
	public String postDeletePattern(@RequestParam("delete") String strId) {
		
		int id = Integer.parseInt(strId);
		dateCalcService.deletePattern(id);
		
		return "redirect:/date-calculation/edit";
	}
}
