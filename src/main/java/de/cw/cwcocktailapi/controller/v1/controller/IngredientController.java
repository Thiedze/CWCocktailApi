package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.IngredientsApi;
import de.cw.cwcocktailapi.controller.v1.mapper.IngredientMapper;
import de.cw.cwcocktailapi.controller.v1.model.ImageDto;
import de.cw.cwcocktailapi.controller.v1.model.IngredientCategoryDto;
import de.cw.cwcocktailapi.controller.v1.model.IngredientDto;
import de.cw.cwcocktailapi.controller.v1.model.RatingDto;
import de.cw.cwcocktailapi.service.IngredientService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class IngredientController implements IngredientsApi {

  private final IngredientService ingredientService;

  public IngredientController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @Override
  public ResponseEntity<IngredientDto> ingredient(Long ingredientId) {
    return null;
  }

  @Override
  public ResponseEntity<List<IngredientCategoryDto>> ingredientCategory(Long ingredientId) {
    return null;
  }

  @Override
  public ResponseEntity<ImageDto> ingredientImage(Long ingredientId) {
    return null;
  }

  @Override
  public ResponseEntity<RatingDto> ingredientRating(Long ingredientId) {
    return null;
  }

  @Override
  public ResponseEntity<List<IngredientDto>> ingredients() {
    List<IngredientDto> ingredients = IngredientMapper.MAPPER.convert(ingredientService.ingredients());
    return new ResponseEntity<>(ingredients, HttpStatus.OK);
  }
}
