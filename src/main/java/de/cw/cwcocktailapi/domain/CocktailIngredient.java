package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

  @Transient
  private Long ingredient_id;

  private String quantity;

  @Enumerated(EnumType.STRING)
  private Unit unit;

  @OneToOne
  private Ingredient ingredient;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "cocktail_ingredient_id")
  private List<Ingredient> alternativeIngredients;

}
