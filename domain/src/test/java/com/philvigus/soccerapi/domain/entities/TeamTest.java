package com.philvigus.soccerapi.domain.entities;

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

  @Test
  @DisplayName("setName should set the name field")
  void setFoundedShouldSetTheNameField() {
    final String name = "test name";

    team.setName(name);

    assertEquals(name, team.getName());
  }

  @Test
  @DisplayName("setFoundedIn should set the foundedIn field")
  void setFoundedInShouldSetTheFoundedInField() {
    final Long foundedIn = 1900L;

    team.setFoundedIn(foundedIn);

    assertEquals(foundedIn, team.getFoundedIn());
  }

  @Test
  @DisplayName("setDisbandedIn should set the disbandedIn field")
  void setDisbandedInShouldSetTheDisbandedInField() {
    final Long disbandedIn = 1900L;

    team.setDisbandedIn(disbandedIn);

    assertEquals(disbandedIn, team.getDisbandedIn());
  }
}
