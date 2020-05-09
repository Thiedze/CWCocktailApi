package de.cw.cwcocktailapi.service;

import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  /*@Autowired
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
  }*/
}
