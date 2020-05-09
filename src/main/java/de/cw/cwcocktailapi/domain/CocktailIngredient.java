package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table
public class CocktailIngredient {

  @Id
  @GeneratedValue
  private Long id;

  @Transient
  private Long ingredient_id;

  private String quantity;

  @Enumerated(EnumType.STRING)
  private Unit unit;

  @OneToOne
  private Ingredient ingredient;

  @OneToMany(fetch = FetchType.EAGER)
  private List<Ingredient> alternativeIngredients;

}
