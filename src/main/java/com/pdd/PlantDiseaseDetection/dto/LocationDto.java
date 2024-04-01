package com.pdd.PlantDiseaseDetection.dto;

import java.util.*;

import com.pdd.PlantDiseaseDetection.entity.Disease;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long id;

    private String name;

    private double longitude;

    private double latitude;

}
