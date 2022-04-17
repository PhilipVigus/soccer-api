package com.philvigus.soccerapidomain.factories;

import net.datafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.commons.beanutils.BeanUtils.setProperty;

/**
 * An abstract base class for all entity factories.
 *
 * @param <T> the type of entity the factory produces
 */
public abstract class AbstractBaseEntityFactory<T> {
  /** The Faker instance. */
  protected final Faker faker;

  /** The class of the type the factory produces. */
  protected final Class<T> clazz;

  /** The repository used to save instances the factory produces. */
  protected final JpaRepository<T, Long> repository;

  /** Entity attributes with specific values set by the user. */
  protected Map<String, Object> customAttributes;

  /**
   * Instantiates a new Abstract base factory.
   *
   * @param clazz the class the factory produces
   * @param repository the repository used by the factory to save produced instances
   */
  public AbstractBaseEntityFactory(final Class<T> clazz, final JpaRepository<T, Long> repository) {
    faker = new Faker();

    this.clazz = clazz;
    this.repository = repository;
    this.customAttributes = new ConcurrentHashMap<>();
  }

  /**
   * Creates and saves multiple entities.
   *
   * @param copies the number of entities to create
   * @return the created list of entities
   * @throws FactoryException thrown if an entity could not be created
   */
  public List<T> create(final int copies) throws FactoryException {
    if (copies < 1) {
      throw new IllegalArgumentException("copies must be greater than 0");
    }

    final List<T> entities = new ArrayList<>(copies);

    for (int i = 0; i < copies; i++) {
      final T entity = getEntityWithAttributesSet(customAttributes);
      entities.add(repository.save(entity));
    }

    return entities;
  }

  /**
   * Creates and saves a single entity.
   *
   * @return the created entity
   * @throws FactoryException thrown if an entity could not be created
   */
  public T create() throws FactoryException {
    final T entity = getEntityWithAttributesSet(customAttributes);

    return repository.save(entity);
  }

  /**
   * Creates multiple entities.
   *
   * @param copies the number of entities to create
   * @return the created list of entities
   * @throws FactoryException thrown if an entity could not be made
   */
  public List<T> make(final int copies) throws FactoryException {
    if (copies < 1) {
      throw new IllegalArgumentException("copies must be greater than 0");
    }

    final List<T> entities = new ArrayList<>(copies);

    for (int i = 0; i < copies; i++) {
      final T entity = getEntityWithAttributesSet(customAttributes);
      entities.add(entity);
    }

    return entities;
  }

  /**
   * Creates a single entity.
   *
   * @return the created entity
   * @throws FactoryException thrown if an entity could not be made
   */
  public T make() throws FactoryException {
    return getEntityWithAttributesSet(customAttributes);
  }

  /**
   * Sets the attribute values to be used when creating entities.
   *
   * @param customAttributes attribute and the values set by the user
   * @return the instance of the factory
   */
  public AbstractBaseEntityFactory<T> withAttributes(final Map<String, Object> customAttributes) {
    this.customAttributes = customAttributes;

    return this;
  }

  /**
   * Gets an entity with all required attributes set.
   *
   * @param customAttributes attribute and the values set by the user
   * @return the entity with all required attributes set
   * @throws FactoryException thrown if the entity could not be created or attributes could not be
   *     set
   */
  protected T getEntityWithAttributesSet(final Map<String, Object> customAttributes)
      throws FactoryException {
    final T entity;

    try {
      entity = clazz.getDeclaredConstructor().newInstance();
    } catch (InstantiationException
        | IllegalAccessException
        | IllegalArgumentException
        | InvocationTargetException
        | NoSuchMethodException e) {
      throw new FactoryException(String.format("Unable to create entity of type %s", clazz), e);
    }

    getCombinedAttributes(customAttributes)
        .forEach(
            (name, value) -> {
              try {
                setProperty(entity, name, value);
              } catch (IllegalAccessException | InvocationTargetException e) {
                throw new FactoryException(
                    String.format(
                        "Unable to set property %s to %s on entity of type %s", name, value, clazz),
                    e);
              }
            });

    return entity;
  }

  /**
   * Returns a combination of custom attribute values set by the user and any default attribute
   * values.
   *
   * @param customAttributes attribute and the values set by the user
   * @return the combined attributes
   */
  protected Map<String, Object> getCombinedAttributes(final Map<String, Object> customAttributes) {
    final Map<String, Object> defaultAttributes = defaultAttributes();

    defaultAttributes.putAll(customAttributes);

    return defaultAttributes;
  }

  /**
   * Returns default attribute values for the entity.
   *
   * <p>Must be defined for each factory that extends this class
   *
   * @return the default attributes and their values
   */
  protected abstract Map<String, Object> defaultAttributes();
}
