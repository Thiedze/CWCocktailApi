package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.CocktailsApi;
import de.cw.cwcocktailapi.controller.v1.model.CocktailCategoryDto;
import de.cw.cwcocktailapi.controller.v1.model.CocktailDto;
import de.cw.cwcocktailapi.controller.v1.model.CocktailIngredientDto;
import de.cw.cwcocktailapi.controller.v1.model.GlassDto;
import de.cw.cwcocktailapi.controller.v1.model.ImageDto;
import de.cw.cwcocktailapi.controller.v1.model.MakingStepDto;
import de.cw.cwcocktailapi.controller.v1.model.RatingDto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class CocktailController implements CocktailsApi {

  @Override
  public ResponseEntity<CocktailDto> cocktail(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<CocktailCategoryDto> cocktailCategory(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<ImageDto> cocktailImage(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<List<CocktailIngredientDto>> cocktailIngredients(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<RatingDto> cocktailRating(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<List<CocktailDto>> cocktails(@Valid String names, @Valid String categories,
      @Valid String ingredients, @Valid String ingredientCategories, @Valid Integer ratingGte, @Valid Integer ratingLte,
      @Valid String glass, @Valid Boolean random) {
    return null;
  }

  @Override
  public ResponseEntity<GlassDto> glass(Long cocktailId) {
    return null;
  }

  @Override
  public ResponseEntity<List<MakingStepDto>> makingSteps(Long cocktailId) {
    return null;
  }

}
