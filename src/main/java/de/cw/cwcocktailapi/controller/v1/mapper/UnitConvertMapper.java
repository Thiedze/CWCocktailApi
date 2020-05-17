package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.model.ConvertDto;
import de.cw.cwcocktailapi.domain.UnitConvert;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitConvertMapper extends CwCocktailApiMapper<ConvertDto, UnitConvert> {

  UnitConvertMapper MAPPER = Mappers.getMapper(UnitConvertMapper.class);

  @Override
  ConvertDto convert(UnitConvert object);

  @Override
  List<ConvertDto> convert(List<UnitConvert> list);
}
