package org.example.navigationservice.dto;

import java.util.UUID;

public record LocationDataDTO(
    UUID mobileId,
    Float x,
    Float y,
    Float error_radius,
//    TODO clarify where to use it.
    Integer error_code,
//    TODO clarify where to use it.
    String error_description
) {
}
