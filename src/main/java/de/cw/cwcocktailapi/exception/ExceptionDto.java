package de.cw.cwcocktailapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {

  private String attribute;

  private String errorMessage;

}
