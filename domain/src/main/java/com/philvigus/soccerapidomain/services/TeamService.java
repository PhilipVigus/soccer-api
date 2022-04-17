package com.philvigus.soccerapidomain.services;

import com.philvigus.soccerapidomain.entities.Team;

import java.util.List;

/** The TeamService interface */
public interface TeamService {
  /**
   * Save a {@link com.philvigus.soccerapidomain.entities.Team Team} entity to the database.
   *
   * @param team the team to be saved
   * @return the saved version of the team including its database id
   */
  Team save(Team team);

  /**
   * Returns all {@link com.philvigus.soccerapidomain.entities.Team teams} in the database.
   *
   * @return the list of {@link com.philvigus.soccerapidomain.entities.Team teams}
   */
  List<Team> findAll();
}
