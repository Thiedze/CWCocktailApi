package de.cw.cwcocktailapi.controller.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseDto {

  private SearchDataDto data;

}
