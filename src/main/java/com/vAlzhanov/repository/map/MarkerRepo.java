package com.vAlzhanov.repository.map;

import com.vAlzhanov.models.map.EMarkerType;
import com.vAlzhanov.models.map.MarkerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkerRepo extends MongoRepository<MarkerEntity, String> {

    List<MarkerEntity> findAllByMarkerType(EMarkerType type);
    Optional<MarkerEntity> findByAddressAndName(String name,String address);
}
