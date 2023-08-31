package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.multi.service.MultiService;

@Controller
public class MultiController {

	private final MultiService multiservice;

	public MultiController(MultiService multiservice) {
		this.multiservice = multiservice;
	}

	@GetMapping("multi")
	public String multi(Model model) {

		int result = multiservice.multi(5, 6);
		model.addAttribute("result", result);

		return "multi.html";
	}
}
