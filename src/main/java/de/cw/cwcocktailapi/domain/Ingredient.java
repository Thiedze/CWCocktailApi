package de.cw.cwcocktailapi.domain;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Ingredient {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String producer;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  private byte[] image;

  @ElementCollection
  private Collection<IngredientCategory> categories;

}
