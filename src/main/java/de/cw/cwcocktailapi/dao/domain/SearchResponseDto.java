package de.cw.cwcocktailapi.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseDto {

  private SearchDataDto data;

}
