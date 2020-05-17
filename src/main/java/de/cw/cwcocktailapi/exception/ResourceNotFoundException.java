package de.cw.cwcocktailapi.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends CwCocktailApiException {

  public ResourceNotFoundException(String attribute, String errorMessage) {
    super(attribute, errorMessage, HttpStatus.NOT_FOUND);
  }

}
