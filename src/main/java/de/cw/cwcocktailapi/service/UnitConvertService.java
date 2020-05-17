package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.UnitConvert;
import de.cw.cwcocktailapi.exception.NotAcceptableException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class UnitConvertService {

  public BigDecimal convert(UnitConvert unitConvert) {
    switch (unitConvert.getFrom().getType()) {
      case ML:
        return convertML(unitConvert);
      case CL:
        return convertCL(unitConvert);
      default:
        throw new NotAcceptableException("from", "No converting from " + unitConvert.getFrom().getType() + " defined");
    }
  }

  private BigDecimal convertML(UnitConvert unitConvert) {
    switch (unitConvert.getTo().getType()) {
      case ML:
        return unitConvert.getAmount();
      case L:
        return unitConvert.getAmount().divide(BigDecimal.valueOf(1000), 2, RoundingMode.CEILING);
      default:
        throw new NotAcceptableException("to", "Converting to " + unitConvert.getTo().getType() + " not possible");
    }
  }

  private BigDecimal convertCL(UnitConvert unitConvert) {
    switch (unitConvert.getTo().getType()) {
      case CL:
        return unitConvert.getAmount();
      case L:
        return unitConvert.getAmount().divide(BigDecimal.valueOf(100), 2, RoundingMode.CEILING);
      default:
        throw new NotAcceptableException("to", "Converting to " + unitConvert.getTo().getType() + " not possible");
    }

  }

}
