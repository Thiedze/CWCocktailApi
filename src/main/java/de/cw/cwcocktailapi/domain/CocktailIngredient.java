package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
  @Column(name = "cocktail_ingredient_id")
  private Long id;

  private String quantity;

  @Enumerated(EnumType.STRING)
  private Unit unit;

  @OneToOne
  @JoinColumn(name = "ingredient_id")
  private Ingredient ingredient;

  @ManyToOne
  @JoinColumn(name = "cocktail_id")
  private Cocktail cocktail;

  @Transient
  private Long ingredient_id;

  @Transient
  private List<Ingredient> alternativeIngredients;

}
