package com.philvigus.soccerapidomain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Team Entity Test")
class TeamTest {
  Team team;

  @BeforeEach
  void setUp() {
    team = new Team();
  }

  @Test
  @DisplayName("setName should set the name field")
  void setNameShouldSetTheNameField() {
    final String name = "test name";

    team.setName(name);

    assertEquals(name, team.getName());
  }
}