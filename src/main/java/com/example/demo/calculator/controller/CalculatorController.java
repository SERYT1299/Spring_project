package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;


@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
    @GetMapping("calculator")
    public String showCalculatorForm() {
        return "calculator.html";
    }

    @PostMapping("calculator")
    public String calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, Model model) {
        int result = calculatorService.performCalculation(num1, num2, operator);
        model.addAttribute("result", result);
        return "calculator.html";
    }
}
