package de.cw.cwcocktailapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MakingStep {

  @Id
  @GeneratedValue
  private Long id;

  private String description;

}
