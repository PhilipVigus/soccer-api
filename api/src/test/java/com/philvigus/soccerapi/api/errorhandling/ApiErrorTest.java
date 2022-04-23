package com.philvigus.soccerapi.api.errorhandling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.http.HttpStatus;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

@DisplayName("ApiError Test")
class ApiErrorTest {
  @Test
  @DisplayName("getStatus should get the status")
  void getStatusShouldGetTheStatus() {
    HttpStatus status = HttpStatus.NOT_FOUND;

    ApiError apiError = new ApiError(status, "test error");

    assertEquals(status, apiError.getStatus());
  }

  @Test
  @DisplayName("getError should get the error")
  void getStatusShouldGetTheError() {
    String error = "test error";

    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, error);

    assertEquals(error, apiError.getError());
  }

  @Test
  @DisplayName("getTimestamp should get the timestamp")
  void getTimestampShouldGetTheTimestamp() {
    Clock clock = Clock.fixed(Instant.now(), ZoneId.of("GMT"));
    Instant dateTime = Instant.now(clock);

    try (MockedStatic<Instant> mockedStatic = mockStatic(Instant.class)) {
      mockedStatic.when(Instant::now).thenReturn(dateTime);
      ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "test error");
      assertEquals(dateTime, apiError.getTimestamp());
    }
  }
}
