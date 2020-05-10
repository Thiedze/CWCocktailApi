package de.cw.cwcocktailapi.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cocktail")
public class Cocktail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String description;

  private LocalDate created;

  private LocalDate updated;

  @OneToOne
  private Glass glass;

  @OneToOne
  private Image image;

  @OneToOne
  private Rating rating;

  @OneToOne
  @JoinColumn(name = "cocktail_category_id")
  private CocktailCategory category;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocktail")
  private List<CocktailIngredient> ingredients;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocktail")
  private List<MakingStep> makingSteps;

}
