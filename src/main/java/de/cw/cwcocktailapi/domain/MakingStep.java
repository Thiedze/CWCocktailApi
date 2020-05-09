package de.cw.cwcocktailapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "makingstep")
public class MakingStep {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "makingstepid")
  private Long id;

  private String description;

}
