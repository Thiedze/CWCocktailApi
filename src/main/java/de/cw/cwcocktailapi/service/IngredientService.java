package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.dao.IngredientDao;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  @Autowired
  private IngredientDao ingredientDao;

  public List<Ingredient> getIngredients() throws IOException {
    return ingredientDao.getIngredients();
  }

}
