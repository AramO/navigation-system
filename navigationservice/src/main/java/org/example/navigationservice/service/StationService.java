package org.example.navigationservice.service;

import org.example.navigationservice.dto.BaseStationDTO;
import org.example.navigationservice.dto.MobileStationDTO;

public interface StationService {
    BaseStationDTO createBaseStation(BaseStationDTO baseStationDTO);

    MobileStationDTO createMobileStation(MobileStationDTO mobileStationDTO);
}
