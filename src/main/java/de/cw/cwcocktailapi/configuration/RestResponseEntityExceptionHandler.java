package de.cw.cwcocktailapi.configuration;

import de.cw.cwcocktailapi.exception.CwCocktailApiException;
import de.cw.cwcocktailapi.exception.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({CwCocktailApiException.class})
  public ResponseEntity<Object> handleCimRestExceptionV4(CwCocktailApiException exception) {
    return new ResponseEntity<>(new ExceptionDto(exception.getAttribute(), exception.getErrorMessage()),
        exception.getHttpStatus());
  }


}
