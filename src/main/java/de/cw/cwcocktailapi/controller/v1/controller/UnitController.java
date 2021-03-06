package de.cw.cwcocktailapi.controller.v1.controller;

import de.cw.cwcocktailapi.controller.v1.mapper.UnitConvertMapper;
import de.cw.cwcocktailapi.controller.v1.mapper.UnitMapper;
import de.cw.cwcocktailapi.controller.v1.model.ConvertDto;
import de.cw.cwcocktailapi.controller.v1.model.UnitDto;
import de.cw.cwcocktailapi.service.UnitService;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class UnitController implements de.cw.cwcocktailapi.controller.v1.api.UnitsApi {

  private final UnitService unitService;

  public UnitController(UnitService unitService) {
    this.unitService = unitService;
  }

  @Override
  public ResponseEntity<ConvertDto> unitConverter(Long unitId, @NotNull @Valid String to,
      @NotNull @Valid BigDecimal amount) {
    ConvertDto convertDto = UnitConvertMapper.MAPPER.convert(unitService.convert(unitId, to, amount));
    return new ResponseEntity<>(convertDto, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<UnitDto>> units() {
    List<UnitDto> units = UnitMapper.MAPPER.convert(unitService.units());
    return new ResponseEntity<>(units, HttpStatus.OK);
  }

}
