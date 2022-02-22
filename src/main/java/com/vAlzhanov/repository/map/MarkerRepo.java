package com.vAlzhanov.repository.map;

import com.vAlzhanov.models.map.Marker;
import com.vAlzhanov.models.map.MarkerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkerRepo extends JpaRepository<Marker, Long> {

    List<Marker> findByMarkerTypes(MarkerType type);
}
