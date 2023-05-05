package org.example.navigationservice.service;

import org.example.navigationservice.dto.LocationDataDTO;
import org.example.navigationservice.dto.ReportDTO;
import org.example.navigationservice.dto.ReportDataDTO;

import java.util.List;

public interface NavigationService {
    List<ReportDTO> processReportData(ReportDataDTO reportDataDTO);

    LocationDataDTO getMobileStationLocation(String uuid);
}
