package org.example.navigationservice.service.impl;

import org.example.navigationservice.dto.LocationDataDTO;
import org.example.navigationservice.dto.ReportDTO;
import org.example.navigationservice.dto.ReportDataDTO;
import org.example.navigationservice.entity.BaseStation;
import org.example.navigationservice.entity.Report;
import org.example.navigationservice.exception.NotFoundException;
import org.example.navigationservice.mapper.ReportMapper;
import org.example.navigationservice.repository.BaseStationRepository;
import org.example.navigationservice.repository.ReportRepository;
import org.example.navigationservice.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private BaseStationRepository baseStationRepository;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<ReportDTO> processReportData(ReportDataDTO reportDataDTO) {
        List<Report> reports = reportMapper.toEntity(reportDataDTO);
        return reportMapper.toDto(reportRepository.saveAll(reports));
    }

    /**
     * TODO clarify requirements.
     * @param uuid
     * @return
     */
    @Override
    public LocationDataDTO getMobileStationLocation(String uuid) {
        Report report = reportRepository.findByMobileStationIdOrderByCreatedAtDesc(UUID.fromString(uuid))
                .orElseThrow(() -> new NotFoundException("Could not find Location with " + uuid));
        BaseStation baseStation = baseStationRepository.findById(report.getBaseStationId())
                .orElseThrow(() -> new NotFoundException("Could not find base station"));
        return new LocationDataDTO(
                report.getMobileStationId(),
                baseStation.getCrdX(),
                baseStation.getCrdY(),
                report.getDistance(),
                1,
                ""
        );
    }
}
