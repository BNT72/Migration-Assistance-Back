package com.vAlzhanov.service;

import com.vAlzhanov.models.map.EMarkerType;
import com.vAlzhanov.models.map.Marker;
import com.vAlzhanov.repository.map.MarkerRepo;
import com.vAlzhanov.repository.map.MarkerTypeRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapService {
    private final MarkerRepo markerRepo;
    private final MarkerTypeRepo markerTypeRepo;

    public MapService(MarkerRepo markerRepo, MarkerTypeRepo markerTypeRepo) {
        this.markerRepo = markerRepo;
        this.markerTypeRepo = markerTypeRepo;
    }

    public List<Marker> getMarkers(String markerType) {
        return markerRepo.findByMarkerTypes(markerTypeRepo.findByName(EMarkerType.valueOf(markerType)));
    }
}
