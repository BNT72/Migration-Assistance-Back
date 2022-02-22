package com.vAlzhanov.models.map;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "markers")
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String address;

    @NotBlank
    @Size(max = 20)
    private double lat;

    @NotBlank
    @Size(max = 20)
    private double lng;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "marker_type_relations",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "marker_id"))
    private Set<MarkerType> markerTypes = new HashSet<>();

}