package org.example.navigationservice.service.impl;

import org.example.navigationservice.dto.BaseStationDTO;
import org.example.navigationservice.dto.MobileStationDTO;
import org.example.navigationservice.entity.BaseStation;
import org.example.navigationservice.entity.MobileStation;
import org.example.navigationservice.mapper.StationMapper;
import org.example.navigationservice.repository.BaseStationRepository;
import org.example.navigationservice.repository.MobileStationRepository;
import org.example.navigationservice.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private BaseStationRepository baseStationRepository;

    @Autowired
    private MobileStationRepository mobileStationRepository;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public BaseStationDTO createBaseStation(BaseStationDTO baseStationDTO) {
        BaseStation baseStation = stationMapper.toEntity(baseStationDTO);
        return stationMapper.toDto(baseStationRepository.save(baseStation));
    }

    @Override
    public MobileStationDTO createMobileStation(MobileStationDTO mobileStationDTO) {
        MobileStation mobileStation = stationMapper.toEntity(mobileStationDTO);
        return stationMapper.toDto(mobileStationRepository.save(mobileStation));
    }
}
