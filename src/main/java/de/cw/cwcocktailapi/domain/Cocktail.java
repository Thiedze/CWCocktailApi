package de.cw.cwcocktailapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cocktail {

  private Long id;

  private String name;

  private List<CocktailIngredient> ingredients;

  private List<MakingStep> makingSteps;
}
