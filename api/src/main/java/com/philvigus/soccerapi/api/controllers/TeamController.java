package com.philvigus.soccerapi.api.controllers;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.services.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

  /**
   * Returns the team with the specified id.
   *
   * <p>Maps to /teams/{id}
   *
   * @param id of the team to return
   * @throws EntityNotFoundException if a team cannot be found
   * @return the team with the specified id
   */
  @GetMapping("/{id}")
  public Team findById(final @PathVariable Long id) {
    final Optional<Team> team = teamService.findById(id);

    if (!team.isPresent()) {
      throw new EntityNotFoundException(String.format("Team with id:%d not found", id));
    }

    return team.get();
  }
}
