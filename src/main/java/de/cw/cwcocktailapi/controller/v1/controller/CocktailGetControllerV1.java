package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.dto.GetCocktailDto;
import de.cw.cwcocktailapi.controller.v1.mapper.CocktailMapper;
import de.cw.cwcocktailapi.service.CocktailService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1", method = RequestMethod.GET)
public class CocktailGetControllerV1 {

  @Autowired
  private CocktailService cocktailService;

  @RequestMapping(value = "/cocktails")
  public List<GetCocktailDto> getCocktails() throws IOException {
    return CocktailMapper.INSTANCE.cocktailsToGetCocktailDtos(cocktailService.getCocktails());
  }

}
