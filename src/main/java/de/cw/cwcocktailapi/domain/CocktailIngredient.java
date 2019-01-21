package de.cw.cwcocktailapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CocktailIngredient {

  private Long id;

  private Long ingredient_id;

  private Ingredient ingredient;

  private String quantity;

  private Unit unit;

  private List<Ingredient> alternativeIngredients;

}
