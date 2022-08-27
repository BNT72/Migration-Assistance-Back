package com.vAlzhanov.models.map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Document
public class MarkerEntity {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private double lat;

    @NotBlank
    private double lng;

    private EMarkerType markerType;

}