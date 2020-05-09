package de.cw.cwcocktailapi.controller.v1.dto;

import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.domain.Unit;
import java.util.List;
import lombok.Data;

@Data
public class CocktailIngredientDto {

  private Long id;

  private Ingredient ingredient;

  private String quantity;

  private Unit unit;

  private List<IngredientDto> alternativeIngredients;

}
