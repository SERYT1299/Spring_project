package com.example.demo.fizzbuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzbuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/fizzBuzz")
    public String fizzBuzz(Model model) {
        model.addAttribute("result", fizzBuzzService.generateFizzBuzz());
        return "fizzBuzz";
    }
}
