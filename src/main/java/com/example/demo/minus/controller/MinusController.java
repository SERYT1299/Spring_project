package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusController {

    @GetMapping("/minus")
    public String showForm() {
        return "minus.html";
    }

    @PostMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2, Model model) {
        int result = num1 - num2;
        model.addAttribute("result", result);
        return "minus.html"; 
    }
}
