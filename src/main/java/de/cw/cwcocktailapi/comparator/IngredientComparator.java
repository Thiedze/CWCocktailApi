package de.cw.cwcocktailapi.comparator;

import de.cw.cwcocktailapi.domain.Ingredient;
import java.util.Comparator;

public class IngredientComparator implements Comparator<Ingredient> {

  @Override
  public int compare(Ingredient ingredient1, Ingredient ingredient2) {
    return ingredient1.getId().compareTo(ingredient2.getId());
  }
}
