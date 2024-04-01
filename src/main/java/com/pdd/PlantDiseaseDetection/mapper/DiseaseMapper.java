package com.pdd.PlantDiseaseDetection.mapper;

import com.pdd.PlantDiseaseDetection.dto.DiseaseDto;
import com.pdd.PlantDiseaseDetection.entity.Disease;

public class DiseaseMapper {

    public static DiseaseDto mapToDiseaseDto(Disease disease) {

        return new DiseaseDto(disease.getId(), disease.getName());
    }

    // public static Disease mapToDisease(DiseaseDto diseaseDto) {

    // return new Disease(diseaseDto.getId(), diseaseDto.getName(),
    // diseaseDto.getLocations());
    // }

}
