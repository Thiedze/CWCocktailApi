package de.cw.cwcocktailapi.domain;

import java.util.List;
import lombok.Data;

@Data
public class Cocktail {

  private Long id;

  private String name;

  private List<CocktailIngredient> ingredients;

}
