package com.philvigus.soccerapi.domain.factories;

/** A general exception used by entity factories. */
public class FactoryException extends RuntimeException {
  /**
   * Instantiates a new Factory exception.
   *
   * @param message the exception message
   * @param err the underlying exception
   */
  public FactoryException(final String message, final Throwable err) {
    super(message, err);
  }
}
