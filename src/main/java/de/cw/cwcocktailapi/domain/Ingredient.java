package de.cw.cwcocktailapi.domain;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ingredientid")
  private Long id;

  private String name;

  private String producer;

  @ElementCollection(fetch = FetchType.EAGER)
  private Collection<IngredientCategory> categories;

}
