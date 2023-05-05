package org.example.navigationservice.exception.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubErrorDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("path")
  private String path;

  @JsonProperty("message")
  private String message;
}

