package de.cw.cwcocktailapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

  private Long id;

  private String name;

  private String producer;

  private List<IngredientCategory> categories;

}
