package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.dto.IngredientDto;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

  IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

  IngredientDto ingredientToGetIngredientDto(Ingredient ingredient);

  List<IngredientDto> ingredientsToGetIngredientDtos(List<Ingredient> ingredients);

}
