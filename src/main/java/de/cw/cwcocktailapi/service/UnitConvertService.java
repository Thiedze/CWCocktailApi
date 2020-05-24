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
        return scale(unitConvert.getAmount());
      case CL:
        return divide(unitConvert.getAmount(), BigDecimal.valueOf(10));
      case L:
        return divide(unitConvert.getAmount(), BigDecimal.valueOf(1000));
      default:
        throw new NotAcceptableException("to", "Converting to " + unitConvert.getTo().getType() + " not possible");
    }
  }


  private BigDecimal convertCL(UnitConvert unitConvert) {
    switch (unitConvert.getTo().getType()) {
      case CL:
        return scale(unitConvert.getAmount());
      case ML:
        return scale(unitConvert.getAmount().multiply(BigDecimal.valueOf(10)));
      case L:
        return divide(unitConvert.getAmount(), BigDecimal.valueOf(100));
      default:
        throw new NotAcceptableException("to", "Converting to " + unitConvert.getTo().getType() + " not possible");
    }

  }

  private BigDecimal scale(BigDecimal value) {
    return value.setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal divide(BigDecimal value, BigDecimal divider) {
    return value.divide(divider, 2, RoundingMode.HALF_UP);
  }

}
