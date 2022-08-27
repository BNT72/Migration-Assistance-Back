package com.vAlzhanov.service;

import com.vAlzhanov.dto.MarkerDto;
import com.vAlzhanov.models.map.EMarkerType;
import com.vAlzhanov.repository.map.MarkerRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MapService {
    private final MarkerRepo markerRepo;

    public MapService(MarkerRepo markerRepo) {
        this.markerRepo = markerRepo;
    }

    public List<MarkerDto> getMarkers(String markerType) {
        Optional<EMarkerType> type = Optional.of(EMarkerType.valueOf(markerType.substring(0, markerType.length()-1)));
        return  markerRepo
                .findAllByMarkerType(type.orElseThrow(IllegalArgumentException::new))
                .stream()
                .map(MarkerDto::new)
                .toList();


    }
}
