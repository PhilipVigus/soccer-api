package com.philvigus.soccerapi.domain.repositories;

import com.philvigus.soccerapi.domain.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/** The Team repository interface. */
public interface TeamRepository extends JpaRepository<Team, Long> {}
