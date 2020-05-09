package de.cw.cwcocktailapi.controller.v1.dto;

import java.util.List;
import lombok.Data;

@Data
public class CocktailDto {

  private Long id;

  private String name;

  private List<CocktailIngredientDto> ingredients;

  private List<MakingStepDto> makingSteps;

  private String imageUrl;
}
