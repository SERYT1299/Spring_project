package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.AnimalsData;
import com.example.demo.AnimalsAPI.repository.AnimalsRepository;

@Service
public class AnimalService {
	private final AnimalsRepository animalsRepository;

	public AnimalService(AnimalsRepository animalsRepository) {
		this.animalsRepository = animalsRepository;
	}

	public List<AnimalsData> getAnimalsData() throws IOException {
		AnimalsData[] animalList = animalsRepository.getAnimalsData();
		return Arrays.asList(animalList);
	}

	public List<AnimalsData> getSelectedAnimalsData(String animalid) throws IOException {
		AnimalsData[] matchingAnimalsList = animalsRepository.getAnimalDetailByName(animalid);
		return Arrays.asList(matchingAnimalsList);
	}
}
