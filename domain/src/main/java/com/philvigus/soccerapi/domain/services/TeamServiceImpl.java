package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** An implementation of the TeamService interface. */
@Service
public class TeamServiceImpl implements TeamService {
  private final TeamRepository teamRepository;

  /**
   * Instantiates a new Team service.
   *
   * @param teamRepository the team repository used by the service
   */
  public TeamServiceImpl(final TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public Team save(final Team team) {
    return teamRepository.save(team);
  }

  @Override
  public List<Team> findAll() {
    return teamRepository.findAll();
  }

  @Override
  public Optional<Team> findById(Long id) {
    return teamRepository.findById(id);
  }
}
