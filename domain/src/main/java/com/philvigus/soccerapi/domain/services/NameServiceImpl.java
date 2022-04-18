package com.philvigus.soccerapi.domain.services;

import com.philvigus.soccerapi.domain.entities.Name;
import com.philvigus.soccerapi.domain.repositories.NameRepository;
import org.springframework.stereotype.Service;

/** An implementation of the NameService interface. */
@Service
public class NameServiceImpl implements NameService {
  private final NameRepository nameRepository;

  /**
   * Instantiates a new Name service.
   *
   * @param nameRepository the name repository used by the service
   */
  public NameServiceImpl(NameRepository nameRepository) {
    this.nameRepository = nameRepository;
  }

  @Override
  public Name save(Name name) {
    return nameRepository.save(name);
  }
}
