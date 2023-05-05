package org.example.navigationservice.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

public record BaseStationDTO(
        UUID id,
        String stationName,
        Float crdX,
        Float crdY,
        Float detectionRadiusInMeters,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
