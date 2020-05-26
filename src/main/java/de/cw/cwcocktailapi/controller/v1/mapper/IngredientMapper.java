package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.model.IngredientDto;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper extends CwCocktailApiMapper<IngredientDto, Ingredient> {

  IngredientMapper MAPPER = Mappers.getMapper(IngredientMapper.class);

  @Override
  IngredientDto convert(Ingredient object);

  @Override
  List<IngredientDto> convert(List<Ingredient> list);
}
