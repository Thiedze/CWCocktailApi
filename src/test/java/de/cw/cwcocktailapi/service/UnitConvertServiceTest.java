package de.cw.cwcocktailapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.cw.cwcocktailapi.domain.Unit;
import de.cw.cwcocktailapi.domain.UnitConvert;
import de.cw.cwcocktailapi.domain.UnitType;
import de.cw.cwcocktailapi.exception.NotAcceptableException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitConvertServiceTest {

  private UnitConvertService unitConvertService;

  @BeforeEach
  public void setuo() {
    unitConvertService = new UnitConvertService();
  }

  @Test
  void convert() {
    convertCLToCLTest();
    convertCLToMLTest();
    convertCLToLTest();

    convertMLToML();
    convertMLToCL();
    convertMLToL();

    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.DASH));

    try {
      unitConvert.setFrom(createUnit(UnitType.DASH));
      BigDecimal amount = unitConvertService.convert(unitConvert);
      assertNull(amount);
    } catch (NotAcceptableException notAcceptableException) {
      assertEquals("from", notAcceptableException.getAttribute());
    }
  }

  private void convertMLToL() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.ML));
    unitConvert.setTo(createUnit(UnitType.L));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP), amount);

    unitConvert.setAmount(BigDecimal.valueOf(25));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(0.03).setScale(2, RoundingMode.HALF_UP), amount);
  }

  private void convertMLToCL() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.ML));
    unitConvert.setTo(createUnit(UnitType.CL));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(0.25).setScale(2, RoundingMode.HALF_UP), amount);
  }

  private void convertMLToML() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.ML));
    unitConvert.setTo(createUnit(UnitType.ML));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_UP), amount);

    try {
      unitConvert.setTo(createUnit(UnitType.DASH));
      amount = unitConvertService.convert(unitConvert);
      assertNull(amount);
    } catch (NotAcceptableException notAcceptableException) {
      assertEquals("to", notAcceptableException.getAttribute());
    }
  }

  private void convertCLToLTest() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.CL));
    unitConvert.setTo(createUnit(UnitType.L));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(0.03), amount);

    unitConvert.setAmount(BigDecimal.valueOf(255));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.55), amount);
  }

  private void convertCLToCLTest() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.CL));
    unitConvert.setTo(createUnit(UnitType.CL));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_UP), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.4));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.4).setScale(2, RoundingMode.HALF_UP), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.31));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.31), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.314));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.31), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.317));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.32), amount);

    try {
      unitConvert.setTo(createUnit(UnitType.DASH));
      amount = unitConvertService.convert(unitConvert);
      assertNull(amount);
    } catch (NotAcceptableException notAcceptableException) {
      assertEquals("to", notAcceptableException.getAttribute());
    }

  }

  private void convertCLToMLTest() {
    UnitConvert unitConvert = new UnitConvert();
    unitConvert.setFrom(createUnit(UnitType.CL));
    unitConvert.setTo(createUnit(UnitType.ML));

    unitConvert.setAmount(BigDecimal.valueOf(2.5));
    BigDecimal amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(25.0).setScale(2, RoundingMode.HALF_UP), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.545));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(25.45), amount);

    unitConvert.setAmount(BigDecimal.valueOf(2.565));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(25.65), amount);

    unitConvert.setAmount(BigDecimal.valueOf(25.65));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(256.5).setScale(2, RoundingMode.HALF_UP), amount);

    unitConvert.setAmount(BigDecimal.valueOf(0.2565));
    amount = unitConvertService.convert(unitConvert);
    assertEquals(BigDecimal.valueOf(2.57), amount);
  }

  private Unit createUnit(UnitType unitType) {
    Unit unit = new Unit();
    unit.setType(unitType);
    return unit;
  }

}