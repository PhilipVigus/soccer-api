package com.philvigus.soccerapi.dataimports.services;

/** The TeamImporterService interface. */
public interface TeamImporterService {
  /**
   * Imports a team.
   *
   * @param data the data to import the team from
   */
  void importTeam(String[] data);
}
