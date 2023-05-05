package org.example.navigationservice.dto;

import java.util.List;
import java.util.UUID;

public record ReportDataDTO(
        UUID baseStationId,
        List<ReportDTO> reports
) {
}
