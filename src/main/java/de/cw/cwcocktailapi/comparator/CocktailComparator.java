package de.cw.cwcocktailapi.comparator;

import de.cw.cwcocktailapi.domain.Cocktail;
import java.util.Comparator;

public class CocktailComparator implements Comparator<Cocktail> {

  @Override
  public int compare(Cocktail cocktail1, Cocktail cocktail2) {
    return cocktail1.getId().compareTo(cocktail2.getId());
  }
}
