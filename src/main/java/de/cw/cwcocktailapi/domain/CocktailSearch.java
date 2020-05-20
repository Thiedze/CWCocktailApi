package de.cw.cwcocktailapi.domain;

import java.util.Arrays;
import java.util.List;
import lombok.Data;

@Data
public class CocktailSearch {

  private List<String> names;

  private List<String> categories;

  private List<String> ingredients;

  private List<String> ingredientCategories;

  private Integer ratingGte;

  private Integer ratingLte;

  private String glass;

  private Boolean random;

  private List<String> convertToList(String valuesAsString) {
    if (valuesAsString != null) {
      return Arrays.asList(valuesAsString.split(","));
    } else {
      return null;
    }
  }

  public void setNames(String names) {
    this.names = convertToList(names);
  }

  public void setCategories(String categories) {
    this.categories = convertToList(categories);
  }

  public void setIngredients(String ingredients) {
    this.ingredients = convertToList(ingredients);
  }

  public void setIngredientCategories(String ingredientCategories) {
    this.ingredientCategories = convertToList(ingredientCategories);
  }

}
