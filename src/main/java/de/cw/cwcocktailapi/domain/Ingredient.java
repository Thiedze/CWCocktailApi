package de.cw.cwcocktailapi.domain;

import lombok.Data;

@Data
public class Ingredient {

  private Long id;

  private String name;

  private String producer;

  private IngredientCategory category;

}
