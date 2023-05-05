package org.example.navigationservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record MobileStationDTO(
        UUID id,
        String stationName,
        Float crdX,
        Float crdY,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
