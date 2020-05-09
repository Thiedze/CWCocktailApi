package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.domain.Ingredient;
import de.cw.cwcocktailapi.service.IngredientService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class IngredientControllerV1 {

  private final IngredientService ingredientService;

  public IngredientControllerV1(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @RequestMapping(value = "/ingredients")
  public List<Ingredient> getIngredients() {
    return ingredientService.getIngredients();
  }

  @RequestMapping(value = "/ingredients/{ingredientId}")
  public Ingredient getIngredient(@PathVariable Long ingredientId) {
    return ingredientService.getIngredient(ingredientId);
  }

}
