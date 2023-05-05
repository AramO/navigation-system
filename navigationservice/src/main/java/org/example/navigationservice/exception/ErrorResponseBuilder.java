package org.example.navigationservice.exception;

import org.example.navigationservice.exception.dto.ErrorResponseDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * A builder to create new error response.
 */
public final class ErrorResponseBuilder {
    private Integer statusCode;
    private String statusName;
    private Throwable exception;
    private Boolean debugModeEnabled;
    private List errors = new ArrayList<>();

    public void statusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void statusName(String statusName) {
        this.statusName = statusName;
    }

    public <T> void errors(List<T> errors) {
        this.errors = errors;
    }

    public void debugModeEnabled(Boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
    }

    public void exception(Throwable exception) {
        this.exception = exception;
    }

    public ErrorResponseDTO build() {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setErrors(this.errors);
        errorResponseDTO.setTimestamp(LocalDateTime.now(ZoneOffset.UTC));
        if(this.debugModeEnabled) {
            errorResponseDTO.setException(this.exception.getClass().getName());
        }
        errorResponseDTO.setMessage(this.exception.getLocalizedMessage());
        errorResponseDTO.setStatusName(this.statusName);
        errorResponseDTO.setStatusCode(statusCode);
        return errorResponseDTO;
    }
}
