package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.AnimalsData;
import com.example.demo.AnimalsAPI.service.AnimalService;

@Controller
public class AnimalController {

	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/search")
	public String showSearchForm(Model model) throws IOException {
		List<AnimalsData> animalList = animalService.getAnimalsData();
		model.addAttribute("animalList", animalList);
		return "animalsSearch.html";
	}

	@PostMapping("/result")
	public String animalDetails(@RequestParam("animalid") String animalid, Model model) throws IOException {
		List<AnimalsData> matchingAnimalsList = animalService.getSelectedAnimalsData(animalid);
		model.addAttribute("matchingAnimalsList", matchingAnimalsList);
		return "animalsResult.html";
	}
}
