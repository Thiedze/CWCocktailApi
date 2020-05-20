package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.model.CocktailDto;
import de.cw.cwcocktailapi.domain.Cocktail;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CocktailMapper extends CwCocktailApiMapper<CocktailDto, Cocktail> {

  CocktailMapper MAPPER = Mappers.getMapper(CocktailMapper.class);

  @Override
  CocktailDto convert(Cocktail object);

  @Override
  List<CocktailDto> convert(List<Cocktail> list);

}
