package de.cw.cwcocktailapi.controller.v1.mapper;

import de.cw.cwcocktailapi.controller.v1.dto.GetIngredientDto;
import de.cw.cwcocktailapi.domain.Ingredient;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

  IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

  GetIngredientDto ingredientToGetIngredientDto(Ingredient ingredient);

  List<GetIngredientDto> ingredientsToGetIngredientDtos(List<Ingredient> ingredients);

}
