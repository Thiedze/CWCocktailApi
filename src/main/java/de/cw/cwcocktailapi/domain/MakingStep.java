package de.cw.cwcocktailapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "making_step")
public class MakingStep {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "making_step_id")
  private Long id;

  private String description;

  private Integer position;

  @Enumerated(EnumType.STRING)
  private Language language = Language.EN;

  @ManyToOne
  @JoinColumn(name = "cocktail_id")
  private Cocktail cocktail;

}
