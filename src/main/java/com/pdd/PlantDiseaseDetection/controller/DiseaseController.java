package com.pdd.PlantDiseaseDetection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.pdd.PlantDiseaseDetection.dto.DiseaseDto;
import com.pdd.PlantDiseaseDetection.service.DiseaseService;

@RestController
@RequestMapping("/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/all")
    public ResponseEntity<List<DiseaseDto>> getAllDiseases() {
        List<DiseaseDto> diseaseDtos = diseaseService.getAllDiseases();
        return ResponseEntity.ok(diseaseDtos);
    }

    // Get the most prevalent disease in a specific area
    @GetMapping("/most-prevalent/{locationId}")
    public ResponseEntity<DiseaseDto> getMostPrevalentDiseaseInLocation(
            @PathVariable(value = "locationId") Long locationId) {
        DiseaseDto diseaseDto = diseaseService.findMostPrevalentDiseaseInLocation(locationId);
        return ResponseEntity.ok(diseaseDto);
    }

    // @PostMapping("/add")
    // public ResponseEntity<DiseaseDto> createDisease(@RequestBody DiseaseDto
    // diseaseDto) {
    // DiseaseDto saveDiseaseDto = diseaseService.createDisease(diseaseDto);
    // return new ResponseEntity<>(saveDiseaseDto, HttpStatus.CREATED);
    // }
}
