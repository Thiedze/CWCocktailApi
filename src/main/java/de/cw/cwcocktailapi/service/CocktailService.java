package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.dao.CocktailDao;
import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.CocktailIngredient;
import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.domain.IngredientCategory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

  @Autowired
  private CocktailDao cocktailDao;

  @Autowired
  private IngredientService ingredientService;

  private void setAndGetCocktailIngredients(List<Cocktail> cocktails,
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
  }

  private void setAndGetAlternativeCocktailIngredients(List<Cocktail> cocktails,
      List<Ingredient> ingredients) {
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        cocktailIngredient.setAlternativeIngredients(ingredients.stream().filter(ingredient ->
            !cocktailIngredient.getIngredient().getId().equals(ingredient.getId()) && ingredient
                .getCategories().containsAll(cocktailIngredient.getIngredient().getCategories())
        ).collect(Collectors.toList()));
      }
    }
  }

  private List<Cocktail> filterCocktailsByCategories(List<Cocktail> cocktails,
      List<IngredientCategory> filterCategories, Integer missingCategories) {
    Set<Cocktail> filteredCocktails = new HashSet<>();
    for (Cocktail cocktail : cocktails) {
      Integer countFitCategories = 0;
      for (CocktailIngredient ingredient : cocktail.getIngredients()) {
        for (IngredientCategory category : ingredient.getIngredient().getCategories()) {
          for (IngredientCategory filterCategory : filterCategories) {
            if (filterCategory.equals(category)) {
              countFitCategories += 1;
            }
          }
        }
      }
      if (countFitCategories.equals(filterCategories.size() - missingCategories)) {
        filteredCocktails.add(cocktail);
      }
    }
    return new ArrayList<>(filteredCocktails);
  }

  public List<Cocktail> getCocktails(List<IngredientCategory> categories,
      Integer missingCategories) throws IOException {
    return filterCocktailsByCategories(getCocktails(), categories, missingCategories);
  }

  private List<Cocktail> getCocktails() throws IOException {
    List<Cocktail> cocktails = cocktailDao.getCocktails();
    List<Ingredient> ingredients = ingredientService.getIngredients();
    setAndGetCocktailIngredients(cocktails, ingredients);
    setAndGetAlternativeCocktailIngredients(cocktails, ingredients);
    return cocktails;
  }

  public Cocktail getCocktail(Long cocktailId) throws IOException {
    List<Cocktail> cocktails = getCocktails();
    for (Cocktail cocktail : cocktails) {
      if (cocktail.getId().equals(cocktailId)) {
        return cocktail;
      }
    }
    throw new ResourceNotFoundException();
  }

}
