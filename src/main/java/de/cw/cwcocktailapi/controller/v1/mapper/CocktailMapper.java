package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.dto.GetCocktailDto;
import de.cw.cwcocktailapi.domain.Cocktail;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CocktailMapper {

  CocktailMapper INSTANCE = Mappers.getMapper(CocktailMapper.class);

  GetCocktailDto cocktailToGetCocktailDto(Cocktail cocktail);

  List<GetCocktailDto> cocktailsToGetCocktailDtos(List<Cocktail> cocktails);


}
