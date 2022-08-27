package com.vAlzhanov.dto;

import com.vAlzhanov.models.map.MarkerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MarkerDto {


    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private double lat;

    @NotBlank
    private double lng;

    public MarkerDto(MarkerEntity entity) {
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.lat = entity.getLat();
        this.lng = entity.getLng();
    }
}