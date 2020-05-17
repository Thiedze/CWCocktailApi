package de.cw.cwcocktailapi.domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UnitConvert {

  private Unit from;

  private Unit to;

  private BigDecimal amount;

  private BigDecimal result;

}
