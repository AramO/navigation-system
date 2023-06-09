package org.example.navigationservice.repository;

import org.example.navigationservice.entity.BaseStation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseStationRepository extends CrudRepository<BaseStation, UUID> {
}
