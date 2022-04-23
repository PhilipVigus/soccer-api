package com.philvigus.soccerapi.api.controllers;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.factories.entities.TeamFactory;
import com.philvigus.soccerapi.domain.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DisplayName("Teams controller integration test")
class TeamsControllerIntegrationTest {
  TeamFactory teamFactory;

  @Autowired TeamRepository teamRepository;

  @Autowired MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    teamFactory = new TeamFactory(teamRepository);
  }

  @Test
  @DisplayName("When GET /teams is hit it returns all teams")
  @Transactional
  void whenGetTeamsThenReturnsAllTeams() throws Exception {
    final List<Team> teams = teamFactory.create(2);

    mockMvc
        .perform(get("/teams"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].name").value(teams.get(0).getName()))
        .andExpect(jsonPath("$[1].name").value(teams.get(1).getName()));
  }

  @Test
  @DisplayName("When GET /teams/{id} is hit it returns the team with the specified id")
  @Transactional
  void whenGetTeamsIdThenReturnsTeamWithId() throws Exception {
    final Team team = teamFactory.create();

    mockMvc
        .perform(get("/teams/" + team.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(team.getId()))
        .andExpect(jsonPath("$.name").value(team.getName()))
        .andExpect(jsonPath("$.foundedIn").value(team.getFoundedIn()))
        .andExpect(jsonPath("$.disbandedIn").value(team.getDisbandedIn()));
  }

  @Test
  @DisplayName(
      "When GET /teams/{id} is hit with an id that doesn't exist, it returns a not found error")
  @Transactional
  void whenGetTeamsInvalidIdThenReturnsError() throws Exception {
    mockMvc
        .perform(get("/teams/12345678"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.status").value("NOT_FOUND"))
        .andExpect(jsonPath("$.error").value("Team with id:12345678 not found"));
  }
}
