package com.philvigus.soccerapi.domain.factories;

import com.philvigus.soccerapi.domain.entities.Team;
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

    attributes.put("name", faker.lorem().sentence(1, 3));

    return attributes;
  }
}
