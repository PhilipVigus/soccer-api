package com.philvigus.soccerapi.dataimports.services;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("TeamImporterServiceImpl Test")
class TeamImporterServiceImplTest {
  TeamImporterServiceImpl teamImporterService;

  @Mock TeamService teamService;

  @Captor ArgumentCaptor<Team> teamCaptor;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamImporterService = new TeamImporterServiceImpl(teamService);
  }

  @Test
  @DisplayName("It should import a team formatted in the standard format")
  void importStandardTeam() {
    final List<String> data = new ArrayList<>();

    data.add("Test Team (1980)");
    data.add("should be ignored");
    data.add("so should this");
    data.add("");

    teamImporterService.importTeams(data);

    verify(teamService, times(1)).save(teamCaptor.capture());
    assertEquals("Test Team", teamCaptor.getValue().getName());
  }

  @Test
  @DisplayName("It ignores lines specifying alternate team names")
  void ignoreAlternateTeamNameLines() {
    final List<String> data = new ArrayList<>();

    data.add("Old Team Name - see New Team Name");
    data.add("");

    teamImporterService.importTeams(data);

    verify(teamService, times(0)).save(any(Team.class));
  }

  @Test
  @DisplayName("It imports multiple teams")
  void importMultipleTeams() {
    final List<String> data = new ArrayList<>();

    data.add("Test Team 1 (1980)");
    data.add("should be ignored");
    data.add("so should this");
    data.add("");

    data.add("Old Team Name - see New Team Name");
    data.add("");

    data.add("Test Team 2 (1990)");
    data.add("should be ignored");
    data.add("so should this");
    data.add("");

    teamImporterService.importTeams(data);

    verify(teamService, times(2)).save(teamCaptor.capture());

    final List<Team> teams = teamCaptor.getAllValues();

    assertEquals(2, teams.size());
    assertEquals("Test Team 1", teams.get(0).getName());
    assertEquals("Test Team 2", teams.get(1).getName());
  }
}
