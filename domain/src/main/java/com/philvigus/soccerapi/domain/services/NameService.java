package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Name;

/** The NameService interface. */
public interface NameService {
  /**
   * Save a Name entity to the database.
   *
   * @param name the name to be saved
   * @return the saved version of the name including its database id
   */
  Name save(Name name);
}
