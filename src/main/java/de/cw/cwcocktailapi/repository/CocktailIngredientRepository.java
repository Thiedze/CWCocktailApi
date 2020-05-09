package de.cw.cwcocktailapi.repository;

import de.cw.cwcocktailapi.domain.CocktailIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailIngredientRepository extends JpaRepository<CocktailIngredient, Long> {

}
