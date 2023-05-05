package org.example.navigationservice.controller;

import org.example.navigationservice.dto.LocationDataDTO;
import org.example.navigationservice.dto.ReportDTO;
import org.example.navigationservice.dto.ReportDataDTO;
import org.example.navigationservice.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @PostMapping("/base-station/report")
    public ResponseEntity<List<ReportDTO>> reportBaseStationData(@RequestBody ReportDataDTO reportDataDTO) {
        List<ReportDTO> reportDTOS = navigationService.processReportData(reportDataDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reportDTOS);
    }

    @GetMapping("/location/{uuid}")
    public ResponseEntity<LocationDataDTO> getMobileStationLocation(@PathVariable String uuid) {
        LocationDataDTO locationDataDTO = navigationService.getMobileStationLocation(uuid);
        return ResponseEntity.ok(locationDataDTO);
    }
}
