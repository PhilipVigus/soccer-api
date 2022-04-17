package com.philvigus.soccerapi.domain.factories;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Team factory Test")
class TeamFactoryTest {
  TeamFactory teamFactory;

  @Mock TeamRepository teamRepository;

  @Captor ArgumentCaptor<Team> teamCaptor;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamFactory = new TeamFactory(teamRepository);
  }

  @Test
  @DisplayName("create should save and return a team with the specified name")
  void createShouldSaveAndReturnATeamWithTheSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    teamFactory.withAttributes(Map.of("name", teamName)).create();

    verify(teamRepository, times(1)).save(teamCaptor.capture());

    assertEquals(teamName, teamCaptor.getValue().getName());
  }

  @Test
  @DisplayName("create should save and return a team with a random name if none is specified")
  void createShouldSaveAndReturnATeamWithARandomNameIfNoneIsSpecified() throws FactoryException {
    teamFactory.create();

    verify(teamRepository, times(1)).save(teamCaptor.capture());

    assertNotEquals("", teamCaptor.getValue().getName());
  }

  @Test
  @DisplayName("create should save and return multiple teams with the specified name")
  void createShouldSaveAndReturnMultipleTeamsWithTheSameSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    teamFactory.withAttributes(Map.of("name", teamName)).create(2);

    verify(teamRepository, times(2)).save(teamCaptor.capture());

    final List<Team> createdTeams = teamCaptor.getAllValues();

    assertEquals(teamName, createdTeams.get(0).getName());
    assertEquals(teamName, createdTeams.get(1).getName());
  }

  @Test
  @DisplayName(
      "create should save and return multiple teams with the random names if none is specified")
  void createShouldSaveAndReturnMultipleTeamsWithRandomNames() throws FactoryException {
    teamFactory.create(2);

    verify(teamRepository, times(2)).save(teamCaptor.capture());

    final List<Team> createdTeams = teamCaptor.getAllValues();

    assertNotEquals("", createdTeams.get(0).getName());
    assertNotEquals("", createdTeams.get(1).getName());
  }

  @Test
  @DisplayName("make should return a team with the specified name")
  void makeShouldReturnATeamWithTheSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    final Team team = teamFactory.withAttributes(Map.of("name", teamName)).make();

    assertEquals(teamName, team.getName());
  }

  @Test
  @DisplayName("make should return a team with a random name if none is specified")
  void makeShouldReturnATeamWithARandomNameIfNoneIsSpecified() throws FactoryException {
    final Team team = teamFactory.make();

    assertNotEquals("", team.getName());
  }

  @Test
  @DisplayName("make should return multiple teams with the specified name")
  void makeShouldReturnMultipleTeamsWithTheSameSpecifiedName() throws FactoryException {
    final String teamName = "test name";

    final List<Team> madeTeams = teamFactory.withAttributes(Map.of("name", teamName)).make(2);

    assertEquals(teamName, madeTeams.get(0).getName());
    assertEquals(teamName, madeTeams.get(1).getName());
  }

  @Test
  @DisplayName(
      "make should save and return multiple teams with the random names if none is specified")
  void makeShouldReturnMultipleTeamsWithRandomNames() throws FactoryException {
    final List<Team> madeTeams = teamFactory.make(2);

    assertNotEquals("", madeTeams.get(0).getName());
    assertNotEquals("", madeTeams.get(1).getName());
  }
}
