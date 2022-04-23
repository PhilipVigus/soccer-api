package com.philvigus.soccerapi.api.serialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

/** Used by Jackson to serialise Instants to a readable format. */
public class TimestampSerialiser extends JsonSerializer<Instant> {
  @Override
  public void serialize(
      final Instant instant, final JsonGenerator generator, final SerializerProvider provider)
      throws IOException {
    try {
      final LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("GMT"));

      generator.writeString(dateTime.toString());
    } catch (DateTimeParseException e) {
      // TODO: handle the exception
    }
  }
}
