package com.philvigus.soccerapidomain.repositories;

import com.philvigus.soccerapidomain.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/** The Team repository interface. */
public interface TeamRepository extends JpaRepository<Team, Long> {}
