package de.cw.cwcocktailapi.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "cocktail_ingredient")
public class CocktailIngredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String quantity;

  private LocalDate created;

  private LocalDate updated;

  @OneToOne
  private Unit unit;

  @OneToOne
  private Ingredient ingredient;

  @ManyToOne
  private Cocktail cocktail;

  @Transient
  private Long ingredient_id;

  @Transient
  private List<Ingredient> alternativeIngredients;

}
