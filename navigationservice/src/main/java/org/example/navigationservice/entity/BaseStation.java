package org.example.navigationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "base_station")
public class BaseStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "crd_x")
    private Float crdX;

    @Column(name = "crd_y")
    private Float crdY;

    @Column(name = "detection_radius_in_meters")
    private Float detectionRadiusInMeters;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
