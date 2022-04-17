package com.philvigus.soccerapi.dataimports.services;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.services.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
  public void importTeams(final List<String> data) {
    final List<String> teamData = new ArrayList<>();

    for (final String line : data) {
      // Empty lines separate the team records in the data
      // If we reach one then we've reached the end of the
      // current team, so import it and clear the data
      if ("".equals(line)) {
        importTeam(teamData);
        teamData.clear();

        continue;
      }

      teamData.add(line);
    }
  }

  private void importTeam(final List<String> teamData) {
    // The lines we're interested in always contain at least one
    // opening bracket
    if (!teamData.get(0).contains("(")) {
      return;
    }

    final String teamName = teamData.get(0).split(" \\(")[0];

    final Team team = new Team();
    team.setName(teamName);

    teamService.save(team);
  }
}
