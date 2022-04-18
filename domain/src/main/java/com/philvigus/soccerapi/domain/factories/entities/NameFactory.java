package com.philvigus.soccerapi.domain.factories.entities;

import com.philvigus.soccerapi.domain.entities.Name;
import com.philvigus.soccerapi.domain.factories.AbstractBaseEntityFactory;
import com.philvigus.soccerapi.domain.repositories.NameRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/** A Name entity factory. */
@Component
public class NameFactory extends AbstractBaseEntityFactory<Name> {
  /**
   * Instantiates a new Name factory.
   *
   * @param repository the repository used to save created names
   */
  public NameFactory(final NameRepository repository) {
    super(Name.class, repository);
  }

  @Override
  protected Map<String, Object> defaultAttributes() {
    return Map.of(
        "content",
        faker.lorem().sentence(1, 3),
        "usedFrom",
        faker.date().past(3650, TimeUnit.DAYS),
        "isPrimary",
        false);
  }
}
