package org.example.navigationservice.repository;

import org.example.navigationservice.entity.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReportRepository extends CrudRepository<Report, UUID> {
    Optional<Report> findByMobileStationIdOrderByCreatedAtDesc(UUID mobileStationId);
}
