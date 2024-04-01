package com.pdd.PlantDiseaseDetection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.pdd.PlantDiseaseDetection.entity.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    @Query("SELECT d FROM Disease d JOIN d.locations l WHERE l.id = :locationId GROUP BY d.id ORDER BY COUNT(d.id) DESC")
    Set<Disease> findDiseasesByLocationId(@Param("locationId") Long locationId);
}
