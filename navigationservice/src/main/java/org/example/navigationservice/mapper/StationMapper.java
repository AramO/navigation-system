package org.example.navigationservice.mapper;

import org.example.navigationservice.dto.BaseStationDTO;
import org.example.navigationservice.dto.MobileStationDTO;
import org.example.navigationservice.entity.BaseStation;
import org.example.navigationservice.entity.MobileStation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StationMapper {
    BaseStationDTO toDto(BaseStation baseStation);

    MobileStationDTO toDto(MobileStation mobileStation);

    BaseStation toEntity(BaseStationDTO baseStationDTO);

    MobileStation toEntity(MobileStationDTO mobileStationDTO);
}
