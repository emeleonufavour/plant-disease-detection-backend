package com.pdd.PlantDiseaseDetection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

import com.pdd.PlantDiseaseDetection.dto.DiseaseDto;
import com.pdd.PlantDiseaseDetection.entity.Disease;
import com.pdd.PlantDiseaseDetection.mapper.DiseaseMapper;
import com.pdd.PlantDiseaseDetection.repository.DiseaseRepository;
import com.pdd.PlantDiseaseDetection.service.DiseaseService;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    public DiseaseDto findMostPrevalentDiseaseInLocation(Long locationId) {
        Set<Disease> diseases = diseaseRepository.findDiseasesByLocationId(locationId);

        // Count occurrences of each disease
        Map<Disease, Long> diseaseCounts = diseases.stream()
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()));

        // Find the disease with the highest count
        Disease disease = diseaseCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        return DiseaseMapper.mapToDiseaseDto(disease);
    }

    @Override
    public List<DiseaseDto> getAllDiseases() {
        List<Disease> diseases = diseaseRepository.findAll();
        List<DiseaseDto> diseaseDtos = diseases.stream()
                .map(source -> new DiseaseDto(source.getId(), source.getName()))
                .collect(Collectors.toList());
        return diseaseDtos;
    }

    @Override
    public DiseaseDto createDisease(Disease disease) {
        //Disease disease = DiseaseMapper.mapToDisease(diseaseDto);
        Disease savedDisease = diseaseRepository.save(disease);
        return DiseaseMapper.mapToDiseaseDto(savedDisease);
    }
}
