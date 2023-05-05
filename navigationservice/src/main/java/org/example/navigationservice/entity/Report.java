package org.example.navigationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "base_station_id")
    private UUID baseStationId;

    @Column(name = "mobile_station_id")
    private UUID mobileStationId;

    @Column(name = "distance")
    private Float distance;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
