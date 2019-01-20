package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.dao.CocktailDao;
import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.CocktailIngredient;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

  @Autowired
  private CocktailDao cocktailDao;

  @Autowired
  private IngredientService ingredientService;

  private List<Cocktail> setAndGetCocktailIngredients(List<Cocktail> cocktails,
      List<Ingredient> ingredients) {
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        for (Ingredient ingredient : ingredients) {
          if (cocktailIngredient.getIngredient_id().equals(ingredient.getId())) {
            cocktailIngredient.setIngredient(ingredient);
            break;
          }
        }
      }
    }
    return cocktails;
  }

  private List<Cocktail> setAndGetAlternativeCocktailIngredients(List<Cocktail> cocktails,
      List<Ingredient> ingredients) {
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        cocktailIngredient.setAlternativeIngredients(ingredients.stream().filter(ingredient ->
            !cocktailIngredient.getIngredient().getId().equals(ingredient.getId()) && ingredient
                .getCategory().equals(cocktailIngredient.getIngredient().getCategory())
        ).collect(Collectors.toList()));
      }
    }
    return cocktails;
  }

  public List<Cocktail> getCocktails() throws IOException {
    List<Cocktail> cocktails = cocktailDao.getCocktails();
    List<Ingredient> ingredients = ingredientService.getIngredients();
    cocktails = setAndGetCocktailIngredients(cocktails, ingredients);
    cocktails = setAndGetAlternativeCocktailIngredients(cocktails, ingredients);
    return cocktails;
  }

}
