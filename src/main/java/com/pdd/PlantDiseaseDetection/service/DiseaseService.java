package com.pdd.PlantDiseaseDetection.service;

import java.util.List;

import com.pdd.PlantDiseaseDetection.dto.DiseaseDto;
import com.pdd.PlantDiseaseDetection.entity.Disease;

public interface DiseaseService {
    DiseaseDto findMostPrevalentDiseaseInLocation(Long locationId);

    List<DiseaseDto> getAllDiseases();

    DiseaseDto createDisease(Disease employeeDto);

}
