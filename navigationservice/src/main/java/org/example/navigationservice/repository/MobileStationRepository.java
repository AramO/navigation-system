package org.example.navigationservice.repository;

import org.example.navigationservice.entity.MobileStation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobileStationRepository extends CrudRepository<MobileStation, UUID> {
}
