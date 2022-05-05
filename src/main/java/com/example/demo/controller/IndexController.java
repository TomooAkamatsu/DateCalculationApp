package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import com.example.demo.service.DateCalcService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/date-calculation")
@RequiredArgsConstructor
@Controller
public class IndexController {

	private final DateCalcService dateCalcService;

	@GetMapping("/index")
	public String getIndex(Model model) {
		return "index";
	}

	@GetMapping("/index/result")
	public String postIndex(Model model, @RequestParam("date") String date) {

//		入力が空だった場合は処理をせずリダイレクト
		if(StringUtils.isEmpty(date)){
			return "redirect:/index";
		}
		
		model.addAttribute("resultList",dateCalcService.calcDate(date));
		model.addAttribute("standartDate", dateCalcService.getStandartDate(date));
		
		return "index";
	}
}
