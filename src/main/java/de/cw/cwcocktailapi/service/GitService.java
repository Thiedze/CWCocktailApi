package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.CocktailIngredient;
import de.cw.cwcocktailapi.repository.CocktailIngredientRepository;
import de.cw.cwcocktailapi.repository.CocktailRepository;
import de.cw.cwcocktailapi.repository.IngredientRepository;
import de.cw.cwcocktailapi.repository.MakingStepRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("dataSource")
public class GitService {

  public final JsonService jsonService;

  public final IngredientRepository ingredientRepository;

  public final CocktailIngredientRepository cocktailIngredientRepository;

  public final MakingStepRepository makingStepRepository;

  public final CocktailRepository cocktailRepository;

  public GitService(JsonService jsonService, IngredientRepository ingredientRepository,
      CocktailIngredientRepository cocktailIngredientRepository, MakingStepRepository makingStepRepository,
      CocktailRepository cocktailRepository) throws IOException {
    this.jsonService = jsonService;
    this.ingredientRepository = ingredientRepository;
    this.cocktailIngredientRepository = cocktailIngredientRepository;
    this.makingStepRepository = makingStepRepository;
    this.cocktailRepository = cocktailRepository;
    this.saveToDatabase();
  }

  private void saveCocktails() throws IOException {
    makingStepRepository.deleteAll();
    cocktailIngredientRepository.deleteAll();
    cocktailRepository.deleteAll();

    List<Cocktail> cocktails = jsonService.getCocktails();
    for (Cocktail cocktail : cocktails) {
      for (CocktailIngredient cocktailIngredient : cocktail.getIngredients()) {
        cocktailIngredient.setIngredient(ingredientRepository.getOne(cocktailIngredient.getIngredient_id()));
      }
      cocktailRepository.save(cocktail);
    }
  }

  private void saveIngredients() throws IOException {
    ingredientRepository.deleteAll();
    ingredientRepository.saveAll(jsonService.getIngredients());
  }

  private void saveToDatabase() throws IOException {
    saveIngredients();
    saveCocktails();
  }

}
