package com.philvigus.soccerapidomain.services;

import com.philvigus.soccerapidomain.entities.Team;
import com.philvigus.soccerapidomain.repositories.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Team Service Test")
class TeamServiceImplTest {
  TeamServiceImpl teamService;

  @Mock
  TeamRepository teamRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamService = new TeamServiceImpl(teamRepository);
  }

  @Test
  @DisplayName("save should call save on the service repository")
  void saveCallsRepositorySave() {
    final Team team = new Team();
    team.setName("test name");

    teamService.save(team);

    verify(teamRepository, times(1)).save(team);
  }

  @Test
  @DisplayName("findAll should call findAll on the service repository")
  void findAllCallsRepositoryFindAll() {
    teamService.findAll();

    verify(teamRepository, times(1)).findAll();
  }
}