package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.model.GlassDto;
import de.cw.cwcocktailapi.domain.Glass;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GlassMapper extends CwCocktailApiMapper<GlassDto, Glass> {

  GlassMapper MAPPER = Mappers.getMapper(GlassMapper.class);

  @Override
  GlassDto convert(Glass object);

  @Override
  List<GlassDto> convert(List<Glass> list);
}
