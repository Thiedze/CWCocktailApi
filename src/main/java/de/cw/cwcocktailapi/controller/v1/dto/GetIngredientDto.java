package de.cw.cwcocktailapi.controller.v1.dto;

import lombok.Data;

@Data
public class GetIngredientDto {

  private Long id;

  private String name;

  private String producer;

  private String category;

}
