package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.api.CocktailsApi;
import de.cw.cwcocktailapi.controller.v1.mapper.CocktailMapper;
import de.cw.cwcocktailapi.controller.v1.model.CocktailCategoryDto;
import de.cw.cwcocktailapi.controller.v1.model.CocktailDto;
import de.cw.cwcocktailapi.controller.v1.model.CocktailIngredientDto;
import de.cw.cwcocktailapi.controller.v1.model.GlassDto;
import de.cw.cwcocktailapi.controller.v1.model.ImageDto;
import de.cw.cwcocktailapi.controller.v1.model.MakingStepDto;
import de.cw.cwcocktailapi.controller.v1.model.RatingDto;
import de.cw.cwcocktailapi.domain.CocktailSearch;
import de.cw.cwcocktailapi.service.CocktailService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class CocktailController implements CocktailsApi {

  private final CocktailService cocktailService;

  public CocktailController(CocktailService cocktailService) {
    this.cocktailService = cocktailService;
  }

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
    CocktailSearch cocktailSearch = new CocktailSearch();
    cocktailSearch.setNames(names);
    cocktailSearch.setCategories(categories);
    cocktailSearch.setIngredientCategories(ingredientCategories);
    cocktailSearch.setIngredients(ingredients);
    cocktailSearch.setGlass(glass);
    cocktailSearch.setRatingGte(ratingGte);
    cocktailSearch.setRatingLte(ratingLte);
    cocktailSearch.setRandom(random);

    List<CocktailDto> cocktails = CocktailMapper.MAPPER.convert(cocktailService.cocktails(cocktailSearch));
    return new ResponseEntity<>(cocktails, HttpStatus.OK);
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
