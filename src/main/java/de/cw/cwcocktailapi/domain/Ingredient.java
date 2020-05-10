package de.cw.cwcocktailapi.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String producer;

  private String description;

  private LocalDate created;

  private LocalDate updated;

  @OneToOne
  private Image image;

  @OneToOne
  private Rating rating;

  @ManyToMany
  @JoinTable(name = "ingredient_ingredient_category", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_category_id"))
  private List<IngredientCategory> categories;

}
