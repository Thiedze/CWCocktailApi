package de.cw.cwcocktailapi.controller.v1.dto;

import java.util.List;
import lombok.Data;

@Data
public class GetCocktailDto {

  private Long id;

  private String name;

  private List<GetCocktailIngredientDto> ingredients;

}
