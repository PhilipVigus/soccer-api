package com.philvigus.soccerapi.dataimports.services;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.services.TeamService;
import org.springframework.stereotype.Service;

/** An implementation of the TeamImporterService interface. */
@Service
public class TeamImporterServiceImpl implements TeamImporterService {
  private final TeamService teamService;

  /**
   * Instantiates a new Team importer service.
   *
   * @param teamService the team service used by the importer
   */
  public TeamImporterServiceImpl(final TeamService teamService) {
    this.teamService = teamService;
  }

  @Override
  public void importTeam(String[] data) {
    final Team team = new Team();
    team.setName(data[0]);

    if (!data[1].isEmpty()) {
      team.setFoundedIn(Long.parseLong(data[1]));
    }

    if (!data[2].isEmpty()) {
      team.setDisbandedIn(Long.parseLong(data[2]));
    }

    teamService.save(team);
  }
}
