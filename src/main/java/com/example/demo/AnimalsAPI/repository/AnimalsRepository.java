package com.example.demo.AnimalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AnimalsAPI.data.AnimalsData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsRepository {

    public AnimalsData[] getAnimalsData() throws IOException {

        String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

        RestTemplate rest = new RestTemplate();

        ResponseEntity<String> response = rest.getForEntity(url, String.class);

        String json = response.getBody();

        ObjectMapper mapper = new ObjectMapper();

        AnimalsData[] animalsList = mapper.readValue(json, AnimalsData[].class);

        return animalsList;
    }
    
    public AnimalsData[] getAnimalDetailByName(String animalId) throws IOException {
    	 String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi?id=" + animalId;

    	    RestTemplate rest = new RestTemplate();

    	    ResponseEntity<String> response = rest.getForEntity(url, String.class);

    	    String json = response.getBody();

    	    ObjectMapper mapper = new ObjectMapper();

    	    AnimalsData[] animalDetail = mapper.readValue(json, AnimalsData[].class);

    	    return animalDetail;
    }
}
