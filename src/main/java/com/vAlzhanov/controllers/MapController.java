package com.vAlzhanov.controllers;

import com.vAlzhanov.dto.MarkerDto;
import com.vAlzhanov.service.MapService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/map")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("/")
    public List<MarkerDto> getMarkers(@RequestBody String markerType) {
        return mapService.getMarkers(markerType);
    }
}

