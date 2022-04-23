package com.philvigus.soccerapi.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Name Entity Test")
class NameTest {
  Name name;

  @BeforeEach
  void setUp() {
    name = new Name();
  }

  @Test
  @DisplayName("setContent should set the content field")
  void setContentShouldSetTheContentField() {
    final String content = "test content";

    name.setContent(content);

    assertEquals(content, name.getContent());
  }

  @Test
  @DisplayName("setUsedFrom should set the usedFrom field")
  void setUsedFromShouldSetTheUsedFromField() {
    final Date date = new Date(0);

    name.setUsedFrom(date);

    assertEquals(date, name.getUsedFrom());
  }

  @Test
  @DisplayName("setUsedTo should set the usedTo field")
  void setUsedToShouldSetTheUsedToField() {
    final Date date = new Date(0);

    name.setUsedTo(date);

    assertEquals(date, name.getUsedTo());
  }

  @Test
  @DisplayName("setIsPrimary should set the isPrimary field")
  void setIsPrimaryShouldSetTheIsPrimaryField() {
    final Boolean isPrimary = true;

    name.setPrimary(isPrimary);

    assertEquals(isPrimary, name.getPrimary());
  }
}
