package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Cocktail {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String imageUrl;

  @OneToMany(cascade = CascadeType.ALL)
  private List<CocktailIngredient> ingredients;

  @OneToMany(cascade = CascadeType.ALL)
  private List<MakingStep> makingSteps;

}
