package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.dto.GetCocktailDto;
import de.cw.cwcocktailapi.controller.v1.mapper.CocktailMapper;
import de.cw.cwcocktailapi.domain.IngredientCategory;
import de.cw.cwcocktailapi.service.CocktailService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class CocktailGetControllerV1 {

  @Autowired
  private CocktailService cocktailService;

  @RequestMapping(value = "/cocktails")
  public List<GetCocktailDto> getCocktails(
      @RequestParam(name = "category", required = false) List<IngredientCategory> categories,
      @RequestParam(required = false, defaultValue = "0") Integer missingCategories)
      throws IOException {
    return CocktailMapper.INSTANCE
        .cocktailsToGetCocktailDtos(cocktailService.getCocktails(categories, missingCategories));
  }

  @RequestMapping(value = "/cocktails/{cocktailId}")
  public GetCocktailDto getCocktail(@PathVariable Long cocktailId) throws IOException {
    return CocktailMapper.INSTANCE
        .cocktailToGetCocktailDto(cocktailService.getCocktail(cocktailId));
  }

}
