package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.repositories.TeamRepository;
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

  @Mock TeamRepository teamRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    teamService = new TeamServiceImpl(teamRepository);
  }

  @Test
  @DisplayName("save should call save on the service repository")
  void saveShouldCallRepositorySave() {
    final Team team = new Team();
    team.setName("test name");

    teamService.save(team);

    verify(teamRepository, times(1)).save(team);
  }

  @Test
  @DisplayName("findAll should call findAll on the service repository")
  void findAllShouldCallRepositoryFindAll() {
    teamService.findAll();

    verify(teamRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("findById should call findById on the service repository")
  void findByIdShouldCallRepositoryFindById() {
    final Long id = 1L;
    teamService.findById(id);

    verify(teamRepository, times(1)).findById(id);
  }
}
