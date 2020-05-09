package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.domain.Cocktail;
import de.cw.cwcocktailapi.domain.IngredientCategory;
import de.cw.cwcocktailapi.service.CocktailService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class CocktailControllerV1 {

  private final CocktailService cocktailService;

  public CocktailControllerV1(CocktailService cocktailService) {
    this.cocktailService = cocktailService;
  }

  @RequestMapping(value = "/cocktails")
  public List<Cocktail> getCocktails(
      @RequestParam(name = "category", required = false) List<IngredientCategory> categories,
      @RequestParam(required = false, defaultValue = "0") Integer missingCategories) {
    return cocktailService.getCocktails(categories, missingCategories);
  }

  @RequestMapping(value = "/cocktails/{cocktailId}")
  public Cocktail getCocktail(@PathVariable Long cocktailId) {
    return cocktailService.getCocktail(cocktailId);
  }

}
