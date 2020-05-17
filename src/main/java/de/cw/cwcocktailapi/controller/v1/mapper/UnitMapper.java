package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.model.UnitDto;
import de.cw.cwcocktailapi.domain.Unit;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitMapper extends CwCocktailApiMapper<UnitDto, Unit> {

  UnitMapper MAPPER = Mappers.getMapper(UnitMapper.class);

  @Override
  UnitDto convert(Unit object);

  @Override
  List<UnitDto> convert(List<Unit> list);
}
