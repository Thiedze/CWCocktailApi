package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.comparator.IngredientComparator;
import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.repository.IngredientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  private final IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public List<Ingredient> getIngredients() {
    List<Ingredient> ingredients = ingredientRepository.findAll();
    ingredients.sort(new IngredientComparator());
    return ingredients;
  }

  public Ingredient getIngredient(Long ingredientId) {
    Optional<Ingredient> ingredientOptional = ingredientRepository.findById(ingredientId);
    return ingredientOptional.orElse(null);
  }
}
