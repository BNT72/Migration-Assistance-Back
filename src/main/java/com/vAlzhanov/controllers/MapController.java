package com.vAlzhanov.controllers;

import com.vAlzhanov.models.map.EMarkerType;
import com.vAlzhanov.models.map.Marker;
import com.vAlzhanov.repository.map.MarkerRepo;
import com.vAlzhanov.repository.map.MarkerTypeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/map")
public class MapController {

    private final MarkerRepo markerRepo;
    private final MarkerTypeRepo markerTypeRepo;

    public MapController(MarkerRepo markerRepo, MarkerTypeRepo markerTypeRepo) {
        this.markerRepo = markerRepo;
        this.markerTypeRepo = markerTypeRepo;
    }

    @PostMapping("/")
    public List<Marker> getMarkers(@RequestBody String markerType) {
        return  markerRepo.findByMarkerTypes(markerTypeRepo.findByName(EMarkerType.valueOf(markerType.substring(0, markerType.length() - 1))));
    }
}

