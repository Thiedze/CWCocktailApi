package de.cw.cwcocktailapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CwCocktailApiException extends RuntimeException {

  private String attribute;

  private String errorMessage;

  private HttpStatus httpStatus;

}
