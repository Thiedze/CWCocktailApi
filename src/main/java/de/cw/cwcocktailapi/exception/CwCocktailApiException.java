package de.cw.cwcocktailapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CwCocktailApiException extends RuntimeException {

  private final String attribute;

  private final String errorMessage;

  private final HttpStatus httpStatus;

}
