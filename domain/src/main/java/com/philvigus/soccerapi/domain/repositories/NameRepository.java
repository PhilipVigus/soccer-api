package com.philvigus.soccerapi.domain.repositories;

import com.philvigus.soccerapi.domain.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;

/** The Name repository interface. */
public interface NameRepository extends JpaRepository<Name, Long> {}
