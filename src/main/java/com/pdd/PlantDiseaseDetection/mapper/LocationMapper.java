package com.pdd.PlantDiseaseDetection.mapper;

import com.pdd.PlantDiseaseDetection.dto.LocationDto;
import com.pdd.PlantDiseaseDetection.entity.Location;

public class LocationMapper {
    public static LocationDto mapToLocationDto(Location location) {

        return new LocationDto(location.getId(), location.getName(), location.getLongitude(), location.getLatitude());
    }

    // public static Location mapToLocationDto(LocationDto locationDto) {

    // return new Location(locationDto.getId(), locationDto.getName(),
    // locationDto.getLongitude(),
    // locationDto.getLatitude(),
    // locationDto.getDiseases());
    // }
}
