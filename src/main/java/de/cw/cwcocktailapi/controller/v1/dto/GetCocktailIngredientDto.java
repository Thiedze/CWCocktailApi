package de.cw.cwcocktailapi.controller.v1.dto;

import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.domain.Unit;
import java.util.List;
import lombok.Data;

@Data
public class GetCocktailIngredientDto {

  private Long id;

  private Ingredient ingredient;

  private Integer quantity;

  private Unit unit;

  private List<GetIngredientDto> alternativeIngredients;

}
