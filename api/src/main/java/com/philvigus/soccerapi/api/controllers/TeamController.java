package com.philvigus.soccerapi.api.controllers;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.services.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** The Team controller. */
@RestController
@RequestMapping("teams")
public class TeamController {
  private final TeamService teamService;

  /**
   * Instantiates a new Team controller.
   *
   * @param teamService the team service used by the controller
   */
  public TeamController(final TeamService teamService) {
    this.teamService = teamService;
  }

  /**
   * Returns all teams. *
   *
   * <p>Maps to /teams
   *
   * @return a list of all teams
   */
  @GetMapping
  public List<Team> findAll() {
    return teamService.findAll();
  }
}
