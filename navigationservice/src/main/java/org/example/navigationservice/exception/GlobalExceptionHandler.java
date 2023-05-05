package org.example.navigationservice.exception;

import org.example.navigationservice.exception.dto.ErrorResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("#{'${spring.profiles.active}' == 'dev'}")
    private boolean isDev;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();

        errorResponseBuilder.debugModeEnabled(isDev);
        errorResponseBuilder.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponseBuilder.statusName(HttpStatus.INTERNAL_SERVER_ERROR.name());
        errorResponseBuilder.exception(exception);
        ErrorResponseDTO errorResponseDTO = errorResponseBuilder.build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request) {
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        errorResponseBuilder.debugModeEnabled(isDev);
        errorResponseBuilder.statusCode(HttpStatus.NOT_FOUND.value());
        errorResponseBuilder.statusName(HttpStatus.NOT_FOUND.name());
        errorResponseBuilder.exception(exception);
        ErrorResponseDTO errorResponseDTO = errorResponseBuilder.build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBadRequestException(Exception exception, WebRequest request) {
        ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
        errorResponseBuilder.debugModeEnabled(isDev);
        errorResponseBuilder.statusCode(HttpStatus.BAD_REQUEST.value());
        errorResponseBuilder.statusName(HttpStatus.BAD_REQUEST.name());
        errorResponseBuilder.exception(exception);
        ErrorResponseDTO errorResponseDTO = errorResponseBuilder.build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }
}
