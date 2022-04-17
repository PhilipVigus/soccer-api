package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Team;

import java.util.List;

/** The TeamService interface */
public interface TeamService {
  /**
   * Save a {@link Team Team} entity to the database.
   *
   * @param team the team to be saved
   * @return the saved version of the team including its database id
   */
  Team save(Team team);

  /**
   * Returns all {@link Team teams} in the database.
   *
   * @return the list of {@link Team teams}
   */
  List<Team> findAll();
}
