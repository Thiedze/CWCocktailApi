package de.cw.cwcocktailapi.exception;

import org.springframework.http.HttpStatus;

public class NotAcceptableException extends CwCocktailApiException {

  public NotAcceptableException(String attribute, String errorMessage) {
    super(attribute, errorMessage, HttpStatus.NOT_ACCEPTABLE);
  }

}
