package de.cw.cwcocktailapi.domain;

import java.util.List;
import lombok.Data;

@Data
public class Ingredient {

  private Long id;

  private String name;

  private String producer;

  private List<IngredientCategory> categories;

}
