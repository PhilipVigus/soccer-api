package com.philvigus.soccerapi.api.errorhandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

/** The global exception handler for the API. */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * Handle entity not found exceptions.
   *
   * @param exception the exception
   * @param request the request
   * @return the response entity
   * @throws JsonProcessingException thrown if the JSON cannot be processed
   */
  @org.springframework.web.bind.annotation.ExceptionHandler({EntityNotFoundException.class})
  protected ResponseEntity<Object> handleEntityNotFoundException(
      final RuntimeException exception, final WebRequest request) throws JsonProcessingException {

    final String error = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage()).toJson();

    return handleExceptionInternal(
        exception, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }
}
