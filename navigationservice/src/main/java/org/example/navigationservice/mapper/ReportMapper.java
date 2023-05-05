package org.example.navigationservice.mapper;

import org.example.navigationservice.dto.ReportDTO;
import org.example.navigationservice.dto.ReportDataDTO;
import org.example.navigationservice.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportDTO toDto(Report report);

    List<ReportDTO> toDto(Iterable<Report> reports);

    @Mappings({
            @Mapping( target = "baseStationId", source = "baseStationId"),
            @Mapping( source = "report.mobileStationId", target = "mobileStationId"),
            @Mapping( source = "report.distance", target = "distance"),
            @Mapping( source = "report.timestamp", target = "createdAt")
    })
    Report toEntity(UUID baseStationId, ReportDTO report);

    default List<Report> toEntity(ReportDataDTO reportDataDTO) {
        return reportDataDTO.reports().stream()
                .map(reportDTO -> toEntity(reportDataDTO.baseStationId(), reportDTO))
                .collect(Collectors.toList());

    }
}
