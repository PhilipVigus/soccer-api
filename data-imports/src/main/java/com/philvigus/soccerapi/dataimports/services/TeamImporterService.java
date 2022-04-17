package com.philvigus.soccerapi.dataimports.services;

import java.util.List;

/** The TeamImporterService interface. */
public interface TeamImporterService {
  /**
   * Import teams.
   *
   * @param data the data to import the teams from
   */
  void importTeams(List<String> data);
}
