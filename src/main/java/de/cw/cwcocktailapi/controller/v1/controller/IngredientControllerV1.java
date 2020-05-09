package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.dto.IngredientDto;
import de.cw.cwcocktailapi.service.IngredientService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class IngredientControllerV1 {

  @Autowired
  private IngredientService ingredientService;

  @RequestMapping(value = "/ingredients")
  public List<IngredientDto> getIngredients() throws IOException {
    /*return IngredientMapper.INSTANCE
        .ingredientsToGetIngredientDtos(ingredientService.getIngredients());*/
    return null;
  }

  @RequestMapping(value = "/ingredients/{ingredientId}")
  public IngredientDto getIngredient(@PathVariable Long ingredientId) throws IOException {
    /*return IngredientMapper.INSTANCE
        .ingredientToGetIngredientDto(ingredientService.getIngredient(ingredientId));*/

    return null;
  }

}
