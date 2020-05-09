package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.dto.CocktailDto;
import de.cw.cwcocktailapi.domain.Cocktail;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CocktailMapper {

  CocktailMapper INSTANCE = Mappers.getMapper(CocktailMapper.class);

  CocktailDto cocktailToGetCocktailDto(Cocktail cocktail);

  List<CocktailDto> cocktailsToGetCocktailDtos(List<Cocktail> cocktails);


}
