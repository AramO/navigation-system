package org.example.navigationservice.controller;

import org.example.navigationservice.dto.BaseStationDTO;
import org.example.navigationservice.dto.MobileStationDTO;
import org.example.navigationservice.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("/base-station")
    public ResponseEntity<BaseStationDTO> createBaseStation(@RequestBody BaseStationDTO baseStationDTO) {
        BaseStationDTO baseStation = stationService.createBaseStation(baseStationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(baseStation);
    }

    @PostMapping("/mobile-station")
    public ResponseEntity<MobileStationDTO> createMobileStation(@RequestBody MobileStationDTO mobileStationDTO) {
        MobileStationDTO mobileStation = stationService.createMobileStation(mobileStationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mobileStation);
    }
}
