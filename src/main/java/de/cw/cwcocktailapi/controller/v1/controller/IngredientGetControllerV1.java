package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.dto.GetIngredientDto;
import de.cw.cwcocktailapi.controller.v1.mapper.IngredientMapper;
import de.cw.cwcocktailapi.service.IngredientService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class IngredientGetControllerV1 {

  @Autowired
  private IngredientService ingredientService;

  @RequestMapping(value = "/ingredients")
  public List<GetIngredientDto> getIngredients() throws IOException {
    return IngredientMapper.INSTANCE
        .ingredientsToGetIngredientDtos(ingredientService.getIngredients());
  }

}
