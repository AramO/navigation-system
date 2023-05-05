package org.example.navigationservice.exception.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("timestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime timestamp;

  @JsonProperty("statusCode")
  private Integer statusCode;

  @JsonProperty("statusName")
  private String statusName;

  @JsonProperty("message")
  private String message;

  @JsonProperty("exception")
  private String exception;

  @JsonProperty("errors")
  
  private List<SubErrorDTO> errors = null;

}

