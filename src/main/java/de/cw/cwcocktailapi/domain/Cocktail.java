package de.cw.cwcocktailapi.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  @Column(name = "cocktail_id")
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private GlassType glassType;

  @OneToOne
  @JoinColumn(name = "image_id")
  private Image image;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocktail")
  private List<CocktailIngredient> ingredients;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocktail")
  private List<MakingStep> makingSteps;

}
