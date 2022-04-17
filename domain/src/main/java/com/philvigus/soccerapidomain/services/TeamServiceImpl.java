package com.philvigus.soccerapidomain.services;

import com.philvigus.soccerapidomain.entities.Team;
import com.philvigus.soccerapidomain.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An implementation of the {@link com.philvigus.soccerapidomain.services.TeamService TeamService}
 * interface.
 */
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
}
