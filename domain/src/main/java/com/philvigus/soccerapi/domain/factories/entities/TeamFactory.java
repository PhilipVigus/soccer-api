package com.philvigus.soccerapi.domain.factories.entities;

import com.philvigus.soccerapi.domain.entities.Team;
import com.philvigus.soccerapi.domain.factories.AbstractBaseEntityFactory;
import com.philvigus.soccerapi.domain.repositories.TeamRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** A Team entity factory. */
@Component
public class TeamFactory extends AbstractBaseEntityFactory<Team> {

  /**
   * Instantiates a new Team factory.
   *
   * @param repository the repository used to save created teams
   */
  public TeamFactory(final TeamRepository repository) {
    super(Team.class, repository);
  }

  @Override
  protected Map<String, Object> defaultAttributes() {
    final Map<String, Object> attributes = new ConcurrentHashMap<>();

    final long foundedIn = faker.number().numberBetween(1850, 2020);
    final long disbandedIn = faker.number().numberBetween(foundedIn, 2020);

    attributes.put("name", faker.lorem().sentence(1, 3));
    attributes.put("foundedIn", foundedIn);
    attributes.put("disbandedIn", disbandedIn);

    return attributes;
  }
}
