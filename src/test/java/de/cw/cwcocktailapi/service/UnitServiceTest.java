package de.cw.cwcocktailapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import de.cw.cwcocktailapi.domain.Unit;
import de.cw.cwcocktailapi.domain.UnitConvert;
import de.cw.cwcocktailapi.domain.UnitType;
import de.cw.cwcocktailapi.exception.ResourceNotFoundException;
import de.cw.cwcocktailapi.repository.UnitRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class UnitServiceTest {

  private UnitService unitService;

  @Mock
  private UnitConvertService unitConvertService;

  @Mock
  private UnitRepository unitRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    unitService = new UnitService(unitRepository, unitConvertService);

    when(unitRepository.findAll()).thenReturn(getUnits());
    when(unitRepository.findById(3L)).thenReturn(java.util.Optional.ofNullable(getUnits().get(2)));
    when(unitRepository.findById(0L)).thenReturn(java.util.Optional.ofNullable(getUnits().get(0)));
    when(unitRepository.findByType(UnitType.CL)).thenReturn(java.util.Optional.ofNullable(getUnits().get(1)));

    when(unitConvertService.convert(any(UnitConvert.class))).thenReturn(BigDecimal.valueOf(24));
  }

  private List<Unit> getUnits() {
    List<Unit> units = new ArrayList<>();
    units.add(new Unit());
    units.get(0).setId(1L);
    units.get(0).setType(UnitType.ML);
    units.add(new Unit());
    units.get(1).setId(2L);
    units.get(1).setType(UnitType.CL);
    units.add(new Unit());
    units.get(2).setId(3L);
    units.get(2).setType(UnitType.DASH);
    return units;
  }

  @Test
  void units() {
    List<Unit> units = unitService.units();
    assertEquals(3, units.size());
  }

  @Test
  void unit() {
    Unit unit = unitService.unit(3L);
    assertEquals(3L, unit.getId());
    assertEquals(UnitType.DASH, unit.getType());

    try {
      unit = unitService.unit(1L);
      assertNotNull(unit);
    } catch (ResourceNotFoundException exception) {
      assertEquals(exception.getAttribute(), "unitId");
    }
  }

  @Test
  void convert() {
    UnitConvert unitConvert = unitService.convert(0L, "CL", BigDecimal.valueOf(2.4));
    assertEquals(BigDecimal.valueOf(24), unitConvert.getResult());

    try {
      unitConvert = unitService.convert(0L, "OZ", BigDecimal.valueOf(2.4));
      assertNotNull(unitConvert);
    } catch (ResourceNotFoundException exception) {
      assertEquals(exception.getAttribute(), "type");
    }

  }
}