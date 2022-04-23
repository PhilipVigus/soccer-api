package com.philvigus.soccerapi.api.errorhandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.philvigus.soccerapi.api.serialisers.TimestampSerialiser;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/** Represents an API error. */
public class ApiError {
  private static final ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();

  @Getter private final HttpStatus status;
  @Getter private final String error;

  @JsonSerialize(using = TimestampSerialiser.class)
  @Getter
  private final Instant timestamp;

  /**
   * Instantiates a new API error.
   *
   * @param status the http status
   * @param error the error message
   */
  public ApiError(final HttpStatus status, final String error) {
    this.status = status;
    this.error = error;

    timestamp = Instant.now();
  }

  /**
   * Converts the error into a JSON string.
   *
   * @return a json representation of the error
   * @throws JsonProcessingException a json processing exception
   */
  public String toJson() throws JsonProcessingException {
    return mapper.writeValueAsString(this);
  }
}
