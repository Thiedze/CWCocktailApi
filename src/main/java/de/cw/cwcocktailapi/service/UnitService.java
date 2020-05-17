package de.cw.cwcocktailapi.service;

import de.cw.cwcocktailapi.domain.Unit;
import de.cw.cwcocktailapi.domain.UnitConvert;
import de.cw.cwcocktailapi.domain.UnitType;
import de.cw.cwcocktailapi.exception.ResourceNotFoundException;
import de.cw.cwcocktailapi.repository.UnitRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

  private final UnitRepository unitRepository;

  private final UnitConvertService unitConvertService;

  public UnitService(UnitRepository unitRepository, UnitConvertService unitConvertService) {
    this.unitRepository = unitRepository;
    this.unitConvertService = unitConvertService;
  }

  public List<Unit> units() {
    return unitRepository.findAll();
  }

  public Unit unit(@NotNull Long unitId) {
    Optional<Unit> optional = unitRepository.findById(unitId);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      throw new ResourceNotFoundException("unitId", "The unit id " + unitId.toString() + " does not exist");
    }
  }

  public Unit unit(@NotNull String typeName) {
    if (!EnumUtils.isValidEnum(UnitType.class, typeName.toUpperCase())) {
      throw new ResourceNotFoundException("type", "The type " + typeName + " does not exist");
    }

    Optional<Unit> optional = unitRepository.findByType(UnitType.valueOf(typeName.toUpperCase()));
    if (optional.isPresent()) {
      return optional.get();
    } else {
      throw new ResourceNotFoundException("type", "The type " + typeName + " does not exist");
    }
  }

  public UnitConvert convert(@NotNull Long unitId, @NotNull String to, @NotNull BigDecimal amount) {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(unit(unitId));
    unitConvert.setTo(unit(to));
    unitConvert.setAmount(amount);
    unitConvert.setResult(unitConvertService.convert(unitConvert));
    return unitConvert;
  }
}
