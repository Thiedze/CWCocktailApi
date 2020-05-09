package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cocktail")
public class Cocktail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cocktailid")
  private Long id;

  private String name;

  @OneToMany
  private List<CocktailIngredient> ingredients;

  @OneToMany
  private List<MakingStep> makingSteps;

  private String imageUrl;
  
}
