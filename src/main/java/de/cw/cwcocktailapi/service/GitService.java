package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.repository.CocktailRepository;
import de.cw.cwcocktailapi.repository.IngredientRepository;
import java.io.IOException;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("dataSource")
public class GitService {

  public final JsonService jsonService;

  public final IngredientRepository ingredientRepository;

  public final CocktailRepository cocktailRepository;

  public GitService(JsonService jsonService, IngredientRepository ingredientRepository,
      CocktailRepository cocktailRepository) throws IOException {
    this.jsonService = jsonService;
    this.ingredientRepository = ingredientRepository;
    this.cocktailRepository = cocktailRepository;
    this.saveIngredients();
    this.saveCocktails();
  }

  private void saveCocktails() throws IOException {
    cocktailRepository.saveAll(jsonService.getCocktails());
  }

  private void saveIngredients() throws IOException {
    ingredientRepository.saveAll(jsonService.getIngredients());
  }


}
