package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.comparator.IngredientComparator;
import de.cw.cwcocktailapi.dao.IngredientDao;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  @Autowired
  private IngredientDao ingredientDao;

  public List<Ingredient> getIngredients() throws IOException {
    List<Ingredient> ingredients = ingredientDao.getIngredients();
    ingredients.sort(new IngredientComparator());
    return ingredients;
  }

  public Ingredient getIngredient(Long ingredientId) throws IOException {
    List<Ingredient> ingredients = ingredientDao.getIngredients();
    for (Ingredient ingredient : ingredients) {
      if (ingredient.getId().equals(ingredientId)) {
        return ingredient;
      }
    }
    throw new ResourceNotFoundException();
  }
}
