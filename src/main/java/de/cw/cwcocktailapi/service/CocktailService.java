package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.comparator.CocktailComparator;
import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.CocktailIngredient;
import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.domain.IngredientCategory;
import de.cw.cwcocktailapi.repository.CocktailRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

  private final CocktailRepository cocktailRepository;

  private final IngredientService ingredientService;

  public CocktailService(CocktailRepository cocktailRepository, IngredientService ingredientService) {
    this.cocktailRepository = cocktailRepository;
    this.ingredientService = ingredientService;
  }

  private void getAndSetAlternativeCocktailIngredients(Cocktail cocktail, List<Ingredient> ingredients) {
    for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
      cocktailIngredient.setAlternativeIngredients(ingredients.stream().filter(
          ingredient -> !cocktailIngredient.getIngredient().getId().equals(ingredient.getId()) && ingredient
              .getCategories().containsAll(cocktailIngredient.getIngredient().getCategories()))
          .collect(Collectors.toList()));
    }
  }

  private List<Cocktail> filterCocktailsByCategories(List<Cocktail> cocktails,
      List<IngredientCategory> filterCategories, Integer missingCategories) {
    if (filterCategories != null && !filterCategories.isEmpty()) {
      Set<Cocktail> filteredCocktails = new HashSet<>();
      for (Cocktail cocktail : cocktails) {
        int countFitCategories = 0;
        for (CocktailIngredient ingredient : cocktail.getIngredients()) {
          for (IngredientCategory category : ingredient.getIngredient().getCategories()) {
            for (IngredientCategory filterCategory : filterCategories) {
              if (filterCategory.equals(category)) {
                countFitCategories += 1;
              }
            }
          }
        }
        if (countFitCategories >= filterCategories.size() - missingCategories) {
          filteredCocktails.add(cocktail);
        }
      }
      return new ArrayList<>(filteredCocktails);
    } else {
      return cocktails;
    }
  }

  private List<Cocktail> sort(List<Cocktail> cocktails) {
    cocktails.sort(new CocktailComparator());
    return cocktails;
  }

  public List<Cocktail> getCocktails(List<IngredientCategory> categories, Integer missingCategories) {
    return sort(filterCocktailsByCategories(getCocktails(), categories, missingCategories));
  }

  private void addAdditionalInformations(List<Cocktail> cocktails) {
    List<Ingredient> ingredients = ingredientService.getIngredients();
    for (Cocktail cocktail : cocktails) {
      getAndSetAlternativeCocktailIngredients(cocktail, ingredients);
    }
  }

  private void addAdditionalInformation(Cocktail cocktail) {
    List<Ingredient> ingredients = ingredientService.getIngredients();
    getAndSetAlternativeCocktailIngredients(cocktail, ingredients);
  }

  private List<Cocktail> getCocktails() {
    List<Cocktail> cocktails = cocktailRepository.findAll();
    addAdditionalInformations(cocktails);
    return cocktails;
  }

  public Cocktail getCocktail(Long cocktailId) {
    Optional<Cocktail> cocktailOptional = cocktailRepository.findById(cocktailId);
    if (cocktailOptional.isPresent()) {
      Cocktail cocktail = cocktailOptional.get();
      addAdditionalInformation(cocktail);
      return cocktail;
    } else {
      return null;
    }
  }

}
