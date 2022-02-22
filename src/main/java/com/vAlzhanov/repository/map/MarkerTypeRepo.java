package com.vAlzhanov.repository.map;

import com.vAlzhanov.models.map.EMarkerType;
import com.vAlzhanov.models.map.MarkerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkerTypeRepo  extends JpaRepository<MarkerType, Long> {
    MarkerType findByName(EMarkerType type);
}
