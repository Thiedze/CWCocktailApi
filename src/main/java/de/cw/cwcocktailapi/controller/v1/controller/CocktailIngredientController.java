package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.CocktailIngredientsApi;
import de.cw.cwcocktailapi.controller.v1.model.CocktailIngredientDto;
import de.cw.cwcocktailapi.controller.v1.model.IngredientDto;
import de.cw.cwcocktailapi.controller.v1.model.UnitDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class CocktailIngredientController implements CocktailIngredientsApi {

  @Override
  public ResponseEntity<List<IngredientDto>> alternativeIngredients(Long cocktailIngredientId) {
    return null;
  }

  @Override
  public ResponseEntity<CocktailIngredientDto> cocktailIngredient(Long cocktailIngredientId) {
    return null;
  }

  @Override
  public ResponseEntity<IngredientDto> ingredientFromCocktailIngredient(Long cocktailIngredientId) {
    return null;
  }

  @Override
  public ResponseEntity<UnitDto> unit(Long cocktailIngredientId) {
    return null;
  }

}
