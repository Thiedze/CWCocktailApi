package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cocktailingredient")
public class CocktailIngredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cocktailingredientid")
  private Long id;

  private Long ingredient_id;

  @OneToOne
  private Ingredient ingredient;

  private String quantity;

  private Unit unit;

  @OneToMany
  private List<Ingredient> alternativeIngredients;

}
