package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculatorForm() {
        return "calculator.html";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam String operator, Model model) {
        int result = performCalculation(num1, num2, operator);
        model.addAttribute("result", result);
        return "calculator.html";
    }

    private int performCalculation(int num1, int num2, String operator) {
        switch (operator) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
